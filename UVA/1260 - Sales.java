import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int n = Integer.parseInt(br.readLine());
			int[] a = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++)
				a[i] = Integer.parseInt(st.nextToken());
			int sum_b = 0;
			for(int i = 1; i < n; i++)
				for(int j = 0; j < i; j++)
					sum_b = a[j]<=a[i]?sum_b+1:sum_b;
			out.println(sum_b);
		}
		out.flush();
		out.close();
	}
}
	
	
