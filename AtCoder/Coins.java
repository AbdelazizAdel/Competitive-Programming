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
		int N = sc.nextInt();
		double[] p = new double[N];
		for(int i = 0; i < N; i++)
			p[i] = sc.nextDouble();
		double[][] dp = new double[N + 1][N + 1];
		dp[0][0] = 1;
		for(int i = 1; i <= N; i++) {
			for(int j = 0; j <= N; j++) {
				if(j == 0)
					dp[i][j] = dp[i - 1][j] * (1 - p[i - 1]);
				else
					dp[i][j] = dp[i - 1][j] * (1 - p[i - 1]) + dp[i - 1][j - 1] * p[i - 1];
			}
		}
		double ans = 0;
		for(int i = N / 2 + 1; i <= N; i++)
			ans+=dp[N][i];
		out.println(ans);
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