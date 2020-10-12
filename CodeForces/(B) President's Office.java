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
		int n = sc.nextInt(), m = sc.nextInt();
		char c = sc.next().charAt(0);
		char[][] office = new char[n][m];
		for(int i = 0; i < n; i++) {
			String s = sc.nextLine();
			for(int j = 0; j < m; j++)
				office[i][j] = s.charAt(j);
		}
		HashSet<Character> set = new HashSet();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(office[i][j] == c || office[i][j] == '.')
					continue;
				if(i > 0 && office[i - 1][j] == c)
					set.add(office[i][j]);
				if(i < n - 1 && office[i + 1][j] == c)
					set.add(office[i][j]);
				if(j > 0 && office[i][j - 1] == c)
					set.add(office[i][j]);
				if(j < m - 1 && office[i][j + 1] == c)
					set.add(office[i][j]);
			}
		}
		out.println(set.size());
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