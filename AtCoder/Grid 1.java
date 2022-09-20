import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int H = sc.nextInt();
		int W = sc.nextInt();
		long[][] memo = new long[H][W];
		char[][] grid = new char[H][W];
		for(int i = 0; i < H; i++) {
			String row = sc.nextLine();
			for(int j = 0; j < W; j++)
				grid[i][j] = row.charAt(j);
		}
		memo[0][0] = 1;
		final long MOD = (long)1e9 + 7;
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(grid[i][j] == '#')
					continue;
				if(i > 0)
					memo[i][j] = (memo[i][j] + memo[i - 1][j]) % MOD;
				if(j > 0)
					memo[i][j]= (memo[i][j] + memo[i][j - 1]) % MOD;
			}
		}
		out.println(memo[H - 1][W - 1]);
		out.flush();
		out.close();
	}
	
	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}