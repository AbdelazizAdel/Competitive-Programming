import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class Solution {
	static int N;
	static ArrayList<Integer>[] adjList;
	static long memo[][], MOD = (long)1e9 + 7;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		N = sc.nextInt();
		adjList = new ArrayList[N];
		for(int i = 0; i < N; i++)
			adjList[i] = new ArrayList();
		for(int i = 0; i < N - 1; i++) {
			int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
			adjList[u].add(v);
			adjList[v].add(u);
		}
		memo = new long[N][2];
		for(int i = 0; i < N; i++) {
			memo[i][0] = -1;
			memo[i][1] = -1;
		}
		System.out.println((dp(0, -1, 0) + dp(0, -1, 1)) % MOD);
		out.flush();
		out.close();
	}

	public static long dp(int u, int p, int c) {
		if(memo[u][c] != -1)
			return memo[u][c];
		long ans = 1l;
		for(int v : adjList[u]) {
			if(v == p)
				continue;
			long x = dp(v, u, 1);
			if(c == 1)
				x = (x + dp(v, u, 0));
			ans = (ans * (x % MOD)) % MOD;  
		}
		return memo[u][c] = ans;
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