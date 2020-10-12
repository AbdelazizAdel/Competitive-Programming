import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt(), k = sc.nextInt();
		int[] arr = new int[n], sum = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		for(int i = 0; i < n; i++) {
			if(i > 0)
				sum[i]+=sum[i - 1];
			sum[i]+=arr[i];
		}
		int min = Integer.MAX_VALUE, idx = 0;
		for(int i = 0; i < n - k + 1; i++) {
			int temp = sum[i + k - 1] - (i > 0 ? sum[i - 1] : 0);
			if(temp < min) {
				min = temp;
				idx = i;
			}
		}
		out.println(idx + 1);
		out.flush();
		out.close();
	}

	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}

		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}

		public double nextDouble() throws IOException{return Double.parseDouble(next());}

		public boolean ready() throws IOException {return br.ready();}

	}
}