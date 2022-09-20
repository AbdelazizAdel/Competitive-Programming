import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class Solution {
	static int N, W, w[], v[];
	static long[][] memo;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		N = sc.nextInt();
		W = sc.nextInt();
		w = new int[N];
		v = new int[N];
		int total = 0;
		for(int i = 0; i < N; i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
			total+=v[i];
		}
		memo = new long[N][total + 1];
		for(int i = 0; i < N; i++)
			for(int j = 0; j <= total; j++)
				memo[i][j] = -1;
		for(int i = 0; i <= total; i++)
			dp(0, i);
		int ans = 0;
		for(int i = 0; i <= total; i++)
			if(memo[0][i] != -1 && memo[0][i] <= W)
				ans = Math.max(ans, i);
		out.println(ans);
		out.flush();
		out.close();
	}

	public static long dp(int idx, int rem) {
		if(rem <= 0)
			return 0l;
		if(idx == N)
			return (long) (1e11) + 1;
		if(memo[idx][rem] != -1)
			return memo[idx][rem];
		return memo[idx][rem] = Math.min(w[idx] + dp(idx + 1, rem - v[idx]), dp(idx + 1, rem));
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