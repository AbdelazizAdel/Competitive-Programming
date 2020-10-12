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
		while(sc.ready()) {
			int B = sc.nextInt(), P = sc.nextInt(), M = sc.nextInt();
			B = B % M;
			int ans = binaryExp(B, P, M);
			out.println(ans);
		}
		out.flush();
		out.close();
	}
	
	public static int binaryExp(int b, int p, int m) {
		if(p == 0)
			return 1;
		int temp = binaryExp(b, p / 2, m) % m;
		int ans = (temp * temp) % m;
		if((p & 1) == 1)
			ans = (ans * b) % m;
		return ans;
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