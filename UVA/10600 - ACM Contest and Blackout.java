import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
	static int up[][], max[][], lvl[], l;
	static ArrayList<Pair>[] adjList;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			l = (int) Math.floor(Math.log(N) / Math.log(2)) + 1;
			up = new int[N][l];
			max = new int[N][l];
			lvl = new int[N];
			adjList = new ArrayList[N];
			for (int i = 0; i < N; i++)
				adjList[i] = new ArrayList();
			int M = sc.nextInt();
			Edge[] edges = new Edge[M];
			for (int i = 0; i < M; i++)
				edges[i] = new Edge(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt());
			Arrays.sort(edges);
			UnionFind uf = new UnionFind(N);
			boolean[] taken = new boolean[M];
			int mst = 0;
			for (int i = 0; i < M && uf.size > 1; i++) {
				if (!uf.union(edges[i].u, edges[i].v))
					continue;
				mst += edges[i].w;
				adjList[edges[i].u].add(new Pair(edges[i].v, edges[i].w));
				adjList[edges[i].v].add(new Pair(edges[i].u, edges[i].w));
				taken[i] = true;
			}
			dfs(0, -1, -1);
			int second_best = Integer.MAX_VALUE;
			for (int i = 0; i < M; i++) {
				if (taken[i])
					continue;
				int a = edges[i].u, b = edges[i].v, w = edges[i].w;
				int lca = lca(a, b), maxEdge = Math.max(max(a, lca), max(b, lca));
				second_best = Math.min(second_best, mst + w - maxEdge);
			}
			out.printf("%d %d%n", mst, second_best);
		}
		out.flush();
		out.close();
	}

	public static void dfs(int u, int p, int w) {
		if (p != -1) {
			lvl[u] = lvl[p] + 1;
			up[u][0] = p;
			max[u][0] = w;
		}
		for (int i = 1; i < l; i++) {
			up[u][i] = up[up[u][i - 1]][i - 1];
			max[u][i] = Math.max(max[u][i - 1], max[up[u][i - 1]][i - 1]);
		}
		for (Pair v : adjList[u])
			if (v.n != p)
				dfs(v.n, u, v.c);
	}

	public static int lca(int a, int b) {
		if (lvl[a] < lvl[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		int diff = lvl[a] - lvl[b];
		for (int i = 0; i < l; i++)
			if (((1 << i) & diff) != 0)
				a = up[a][i];
		if (a == b)
			return a;
		for (int i = l - 1; i >= 0; i--) {
			if (up[a][i] != up[b][i]) {
				a = up[a][i];
				b = up[b][i];
			}
		}
		return up[a][0];
	}

	public static int max(int a, int b) {
		int diff = lvl[a] - lvl[b];
		int max_val = 0;
		for (int i = 0; i < l; i++) {
			if (((1 << i) & diff) != 0) {
				max_val = Math.max(max_val, max[a][i]);
				a = up[a][i];
			}
		}
		return max_val;
	}

	static class Pair {
		int n, c;

		public Pair(int a, int b) {
			n = a;
			c = b;
		}
	}

	static class Edge implements Comparable<Edge> {
		int u, v, w;

		public Edge(int a, int b, int c) {
			u = a;
			v = b;
			w = c;
		}

		public int compareTo(Edge e) {
			return w - e.w;
		}
	}

	static class UnionFind {
		int p[], rank[], size;

		public UnionFind(int N) {
			size = N;
			p = new int[N];
			rank = new int[N];
			for (int i = 0; i < N; i++)
				p[i] = i;
		}

		public int findSet(int x) {
			return x == p[x] ? x : (p[x] = findSet(p[x]));
		}

		public boolean union(int x, int y) {
			int p1 = findSet(x), p2 = findSet(y);
			if (p1 == p2)
				return false;
			if (rank[p1] >= rank[p2]) {
				p[p2] = p1;
				if (rank[p1] == rank[p2])
					rank[p1]++;
			} else
				p[p1] = p2;
			size--;
			return true;
		}
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