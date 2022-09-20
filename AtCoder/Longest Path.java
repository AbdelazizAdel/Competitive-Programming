import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class Solution {
	static int N, M, memo[];
	static ArrayList<Integer>[] adjList;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		N = sc.nextInt();
		M = sc.nextInt();
		adjList = new ArrayList[N];
		for(int i = 0; i < N; i++)
			adjList[i] = new ArrayList<Integer>();
		memo = new int[N];
		for(int i = 0; i < N; i++)
			memo[i] = -1;
		for(int i = 0; i < M; i++)
			adjList[sc.nextInt() - 1].add(sc.nextInt() - 1);
		int ans = 0;
		for(int i = 0; i < N; i++)
			if(memo[i] == -1)
				ans = Math.max(ans, dp(i));
		out.println(ans);
		out.flush();
		out.close();
	}

	public static int dp(int u) {
		memo[u] = 0;
		for(int v : adjList[u]) {
			if(memo[v] == -1)
				dp(v);
			memo[u] = Math.max(memo[u], 1 + memo[v]); 
		}
		return memo[u];
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