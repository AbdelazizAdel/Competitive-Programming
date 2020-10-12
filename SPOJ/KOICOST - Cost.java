import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class zizo {
	static final long MOD = (long) 1e9;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int N = sc.nextInt(), M = sc.nextInt();
		Edge[] edges = new Edge[M];
		for(int i = 0; i < M; i++)
			edges[i] = new Edge(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt());
		if(M == 0)
			out.println(0);
		else {
			Arrays.sort(edges);
			long[] suffix_sum = new long[M];
			suffix_sum[M - 1] = edges[M - 1].w;
			for(int i = M - 2; i >= 0; i--)
				suffix_sum[i] = (suffix_sum[i + 1] % MOD + edges[i].w) % MOD;
			UnionFind uf = new UnionFind();
			for(int i = 0; i < N; i++)
				uf.makeSet(i);
			int count  = 0;
			long ans = 0;
			for(int i = 0; i < M; i++) {
				if(uf.findSet(edges[i].u) == uf.findSet(edges[i].v))
					continue;
				long x = uf.getSize(edges[i].u), y = uf.getSize(edges[i].v);
				long sum = (Long)(x * y * suffix_sum[i]) % MOD ;
				ans = (ans + sum) % MOD;
				uf.union(edges[i].u, edges[i].v);
				count++;
				if(count == N - 1)
					break;
			}
			out.println(ans);
		}

		out.flush();
		out.close();
	}

	static class Edge implements Comparable<Edge> {
		int u, v, w;

		public Edge(int a, int b, int c) {
			u = a;
			v = b;
			w = c;
		}

		public int compareTo(Edge x) {
			return x.w - w;
		}
	}

	static class UnionFind {
		HashMap<Integer, Node> map;

		public UnionFind() {
			map = new HashMap<Integer, Node>();
		}

		public void makeSet(int data) {
			Node n = new Node(data);
			map.put(data, n);
		}

		public Node findSet(Node n) {
			if(n.parent == n)
				return n;
			return n.parent = findSet(n.parent);
		}

		public int findSet(int data) {
			return findSet(map.get(data)).data;
		}

		public void union(int x, int y) {
			Node p1 = map.get(findSet(x)), p2 = map.get(findSet(y));
			if(p1 == p2)
				return;
			if(p1.rank >= p2.rank) {
				p2.parent = p1;
				if(p1.rank == p2.rank)
					p1.rank++;
				p1.size+=p2.size;
			}
			else {
				p1.parent = p2;
				p2.size+=p1.size;
			}
		}
		public int getSize(int data) {
			return findSet(map.get(data)).size;
		}
	}

	static class Node {
		int data;
		int rank;
		int size;
		Node parent;

		public Node(int a) {
			data = a;
			rank = 0;
			size = 1;
			parent = this;
		}
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

		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}

		public boolean ready() throws IOException {return br.ready();}


	}
}