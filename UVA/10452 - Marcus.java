import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
	static int N, M;
	static int[] dx = {-1, 0, 0}, dy = {0, 1, -1}; // N E W
	static String[] directions = {"forth", "right", "left"};
	static char[][] grid;
	static final String WORD_OF_GOD = "IEHOVA#";
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = sc.nextInt();
		while(T-->0) {
			M = sc.nextInt();
			N = sc.nextInt();
			grid = new char[M][N];
			for(int i = 0; i < M; i++)
				grid[i] = sc.nextLine().toCharArray();
			int start = 0;
			for(int i = 0; i < N; i++)
				if(grid[M - 1][i] == '@')
					start = i;
			String[] ans = new String[WORD_OF_GOD.length()];
			dfs(M - 1, start, 0, ans);
			for(int i = 0; i < ans.length; i++)
				out.print(ans[i] + (i == ans.length - 1 ? "\n" : " "));
		}
		out.flush();
		out.close();
	}

	public static void dfs(int x, int y, int idx, String[] arr) {
		if(idx == WORD_OF_GOD.length())
			return;
		for(int i = 0; i < 3; i++) {
			int x2 = x + dx[i], y2 = y + dy[i];
			if(isValid(x2, y2) && grid[x2][y2] == WORD_OF_GOD.charAt(idx)) {
				arr[idx] = directions[i];
				dfs(x2, y2, idx + 1, arr);
			}	
		}
	}

	public static boolean isValid(int x, int y) {
		return x >= 0 && x < M && y >= 0 && y < N;
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

		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}

		public boolean ready() throws IOException {return br.ready();}


	}
}