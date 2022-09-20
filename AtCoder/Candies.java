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
		final long MOD = (long) 1e9 + 7;
		int N = sc.nextInt(), K = sc.nextInt();
		int[] a = new int[N + 1];
		for (int i = 1; i <= N; i++)
			a[i] = sc.nextInt();
		long[][] dp = new long[N + 1][K + 1];
		dp[0][0] = 1l;
		for (int i = 1; i <= N; i++) {
			long[] prefix = new long[K + 1];
			for (int j = 0; j <= K; j++) {
				prefix[j] = dp[i - 1][j] % MOD;
				if (j > 0)
					prefix[j] = (prefix[j] % MOD + prefix[j - 1] % MOD) % MOD;
			}
			for (int j = 0; j <= K; j++) {
				long tr = prefix[j];
				int unreachable = j - a[i] - 1;
				if (unreachable >= 0) {
					tr = (tr - prefix[unreachable] + MOD) % MOD;
				}
				dp[i][j] = tr;
			}
		}
		System.out.println(dp[N][K]);
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