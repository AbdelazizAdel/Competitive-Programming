import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
	static int dp[][], lvl[], l;
	static ArrayList<Integer>[] adjList;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			adjList = new ArrayList[N];
			for(int i = 0; i < N; i++)
				adjList[i] = new ArrayList<Integer>();
			lvl = new int[N];
			Arrays.fill(lvl, -1);
			l = (int)Math.ceil(Math.log(N) / Math.log(2));
			if(l == 0)
				l = 1;
			dp = new int[N][l];
			for(int i = 0; i < N; i++) {
				int M = sc.nextInt();
				for(int j = 0; j < M; j++) {
					int v = sc.nextInt() - 1;
					adjList[i].add(v);
					adjList[v].add(i);
				}
			}
			dfs(0, 0);
			int Q = sc.nextInt();
			out.printf("Case %d:%n", t);
			while(Q-- > 0)
				out.printf("%d%n", lca(sc.nextInt() - 1, sc.nextInt() - 1) + 1);
		}
		out.flush();
		out.close();
	}

	public static void dfs(int u, int p) {
		lvl[u] = lvl[p] + 1;
		dp[u][0] = p;
		for(int i = 1; i < l; i++)
			dp[u][i] = dp[dp[u][i - 1]][i - 1];
		for(int v : adjList[u])
			if(v != p)
				dfs(v, u);
	}

	public static int lca(int u, int v) {
		if(lvl[u] < lvl[v]) {
			int temp = u;
			u = v;
			v = temp;
		}
		int diff = lvl[u] - lvl[v];
		for(int i = 0; i < l; i++)
			if(((1 << i) & diff) != 0)
				u = dp[u][i];
		if(u == v)
			return u;
		for(int i = l - 1; i >= 0; i--)
			if(dp[u][i] != dp[v][i]) {
				u = dp[u][i];
				v = dp[v][i];
			}
		return dp[u][0];
	}

	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}

		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}

		public double nextDouble() throws IOException{return Double.parseDouble(next());}

		public boolean ready() throws IOException {return br.ready();}

	}
}