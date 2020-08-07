import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n+1];
		int max1 = 0, max2 = 0;
		for(int i = 0; i<2*n; i++) {
			int x = Integer.parseInt(st.nextToken());
			if(arr[x]==0) {
				max1++;
				arr[x] = 1;
			}
			else {
				if(max1>max2)
					max2 = max1;
				max1--;
			}
		}
		out.println(max2);
		out.flush();
		out.close();
	}
	
}