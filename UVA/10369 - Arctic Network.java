import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = sc.nextInt();
		while(T-- > 0) {
			int S = sc.nextInt(), N = sc.nextInt();
			Pair[] pos = new Pair[N];
			for(int i = 0; i < N; i++)
				pos[i] = new Pair(sc.nextInt(), sc.nextInt());
			UnionFind uf = new UnionFind(N);
			Edge[] edges = new Edge[N * (N - 1) / 2];
			int idx = 0;
			for(int i = 0; i < N; i++)
				for(int j = i + 1; j < N; j++)
					edges[idx++] = new Edge(i, j, Math.sqrt(pow2(pos[i].x - pos[j].x) + pow2(pos[i].y - pos[j].y)));
			Arrays.sort(edges);
			ArrayList<Double> cost = new ArrayList();
			for(int i = 0; i < edges.length && uf.size > 1; i++) {
				if(!uf.union(edges[i].u, edges[i].v))
					continue;
				cost.add(edges[i].w);
			}
			out.printf("%.2f%n", cost.get(cost.size() - S));
		}
		out.flush();
		out.close();
	}
	
	static class Pair {
		int x, y;
		
		public Pair(int a, int b) {
			x = a;
			y = b;
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int u, v;
		double w;
		
		public Edge(int a, int b, double c) {
			u = a;
			v = b;
			w = c;
		}
		
		public int compareTo(Edge e) {
			if(w < e.w)
				return -1;
			if(w > e.w)
				return 1;
			return 0;
		}
	}
	public static int pow2(int x) {
		return x * x;
	}
	
	
	static class UnionFind {
		int p[], rank[], sz[], size;

		public UnionFind(int N) {
			size = N;
			p = new int[N];
			rank = new int[N];
			sz = new int[N];
			for (int i = 0; i < N; i++) {
				p[i] = i;
				sz[i] = 1;
			}
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
				sz[p1]+=sz[p2];
				if (rank[p1] == rank[p2])
					rank[p1]++;
			} else {
				p[p1] = p2;
				sz[p2]+=sz[p1];
			}
			size--;
			return true;
		}
		
		public int getSize(int x) {
			return sz[findSet(x)];
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