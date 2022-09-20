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
		int N = sc.nextInt(), K = sc.nextInt();
		int arr[] = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		long dp[] = new long[N];
		Arrays.fill(dp, Long.MAX_VALUE);
		dp[N - 1] = 0l;
		for (int i = N - 2; i >= 0; i--)
			for(int j = i + 1; j < N && j - i <= K; j++)
				dp[i] = Math.min(dp[i], Math.abs(arr[i] - arr[j]) + dp[j]);
		System.out.println(dp[0]);
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