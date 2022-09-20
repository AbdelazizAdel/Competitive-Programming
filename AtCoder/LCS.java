import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class Solution {
	static int[][] memo;
	static String s, t;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		s = sc.nextLine();
		t = sc.nextLine();
		memo = new int[s.length()][t.length()];
		for(int i = 0; i < s.length(); i++)
			for(int j = 0; j < t.length(); j++)
				memo[i][j] = -1;
		dp(0, 0);
		StringBuilder sb = new StringBuilder();
		print(0, 0, sb);
		System.out.println(sb);
		out.flush();
		out.close();
	}

	public static int dp(int i, int j) {
		if (i == s.length() || j == t.length())
			return 0;
		if (memo[i][j] != -1)
			return memo[i][j];
		if (s.charAt(i) == t.charAt(j))
			return memo[i][j] = 1 + dp(i + 1, j + 1);
		return memo[i][j] = Math.max(dp(i + 1, j), dp(i, j + 1));
	}

	public static void print(int i, int j, StringBuilder sb) {
		if (i == s.length() || j == t.length())
			return;
		if (s.charAt(i) == t.charAt(j)) {
			sb.append(s.charAt(i));
			print(i + 1, j + 1, sb);
		} else if (dp(i + 1, j) >= dp(i, j + 1))
			print(i + 1, j, sb);
		else
			print(i, j + 1, sb);
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