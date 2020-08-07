import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N==0)
				break;
			int[] arr = new int[N];
			int min = 26;
			for(int i = 0; i<N; i++) {
				String x = br.readLine();
				for(int j = 0; j<25; j++)
					if(x.charAt(j)==' ')
						arr[i]++;
				min = arr[i]<min?arr[i]:min;
			}
			int sum = 0;
			for(int i = 0; i<N; i++)
				sum+=arr[i]-min;
			out.println(sum);
		}
		out.flush();
		out.close();
	}
		
}
	
	
