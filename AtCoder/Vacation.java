import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class Solution {
	static int N, a[], b[], c[];
	static long memo[][];
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		N = sc.nextInt();
		a = new int[N];
		b = new int[N];
		c = new int[N];
		for(int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
			c[i] = sc.nextInt();
		}
		memo = new long[N][3];
		System.out.println(dp(0, 0));
		out.flush();
		out.close();
	}
	
	public static long dp(int idx, int prev) {
		if(idx == N)
			return 0l;
		if(memo[idx][prev] != 0)
			return memo[idx][prev];
		long ans = 0l;
		if(idx == 0 || prev != 0)
			ans = Math.max(ans, dp(idx + 1, 0)  + a[idx]);
		if(idx == 0 || prev != 1)
			ans = Math.max(ans, dp(idx + 1, 1)  + b[idx]);
		if(idx == 0 || prev != 2)
			ans = Math.max(ans, dp(idx + 1, 2) + c[idx]);
		return memo[idx][prev] = ans;
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