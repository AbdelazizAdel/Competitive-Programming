import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class Solution {
	static int N, a[];
	static long memo[][], sum[];
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		N = sc.nextInt();
		a = new int[N];
		sum = new long[N];
		for(int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
			sum[i] = a[i];
			if(i > 0)
				sum[i]+=sum[i - 1];
		}
		memo = new long[N][N];
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				memo[i][j] = -1;
		System.out.println(dp(0, N - 1));
		out.flush();
		out.close();
	}
	
	public static long dp(int i, int j) {
		if(i == j)
			return 0l;
		if(i == j - 1)
			return a[i] + a[j];
		if(memo[i][j] != -1)
			return memo[i][j];
		long ans = Long.MAX_VALUE;
		for(int idx = i; idx < j; idx++)
			ans = Math.min(ans, dp(i, idx) + dp(idx + 1, j) + sum(i, j));
		return memo[i][j] = ans;
	}
	
	public static long sum(int i, int j) {
		long ans = sum[j];
		if(i > 0)
			ans-=sum[i - 1];
		return ans;
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