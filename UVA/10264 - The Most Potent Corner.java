import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(5000);
		while(br.ready()) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[1<<n];
			for(int i = 0; i<(1<<n); i++)
				arr[i] = Integer.parseInt(br.readLine());
			int[] sums = new int[1<<n];
			for(int i = 0; i<(1<<n); i++) {
				int sum = 0;
				for(int j = 0; j<n; j++) 
					if((i&(1<<j))==0)
						sum+=arr[i|(1<<j)];
					else
						sum+=arr[i&~(1<<j)];
				sums[i] = sum;
			}
			int max = 0, sum = 0;
			for(int i = 0; i<(1<<n); i++)
				for(int j = 0; j<n; j++) {
					if((i&(1<<j))==0)
						sum=sums[i|(1<<j)]+sums[i];
					else
						sum=sums[i&~(1<<j)]+sums[i];
				max = sum>max?sum:max;
				}
			out.println(max);
		}
		out.flush();
		out.close();
	}
		
}
	
	
