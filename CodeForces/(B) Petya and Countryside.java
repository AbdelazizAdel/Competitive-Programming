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
		int n = sc.nextInt();
		int[] h = new int[n];
		for(int i = 0; i < n; i++)
			h[i] = sc.nextInt();
		int ans = 1;
		for(int i = 0; i < n; i++) {
			int r = 1;
			for(int j = i; j < n - 1; j++) {
				if(h[j] >= h[j + 1])
					r++;
				else
					break;
			}
			int l = 0;
			for(int j = i; j > 0; j--) {
				if(h[j] >= h[j - 1])
					l++;
				else
					break;
			}
			ans = Math.max(ans, l + r);
		}
		System.out.println(ans);
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