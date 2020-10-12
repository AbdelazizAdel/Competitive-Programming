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
		String s = sc.nextLine();
		char[] ans = new char[s.length()];
		int idx = 0;
		for(int i = s.length() - 2; i >= 0; i-=2)
			ans[idx++] = s.charAt(i);
		int i = (s.length() & 1) == 0 ? 1 : 0;
		for(i = i; i < s.length(); i+=2)
			if(idx < s.length())
				ans[idx++] = s.charAt(i);
		System.out.println(new String(ans));
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