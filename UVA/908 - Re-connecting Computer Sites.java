import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class zizo {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		while(sc.ready()) {
			int N = sc.nextInt();
			ArrayList<Edge> edges = new ArrayList<Edge>();
			int before = 0;
			for(int i = 0; i < N - 1; i++) {
				int u = sc.nextInt() - 1, v = sc.nextInt() - 1, w = sc.nextInt();
				edges.add(new Edge(u, v, w));
				before+=w;
			}
			int k = sc.nextInt();
			for(int i = 0; i < k; i++)
				edges.add(new Edge(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt()));
			int m = sc.nextInt();
			for(int i = 0; i < m; i++)
				sc.nextLine();
			Collections.sort(edges);
			UnionFind uf = new UnionFind();
			for(int i = 0; i < N; i++)
				uf.makeSet(i);
			int count  = 0, after = 0;
			for(Edge e : edges) {
				if(!uf.union(e.u, e.v))
					continue;
				after+=e.w;
				count++;
				if(count == N - 1)
					break;
			}
			out.println(before + "\n" + after);
			if(sc.ready())
				out.println();
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
			return w - x.w;
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
		
		public boolean union(int x, int y) {
			Node p1 = map.get(findSet(x)), p2 = map.get(findSet(y));
			if(p1 == p2)
				return false;
			if(p1.rank >= p2.rank) {
				p2.parent = p1;
				if(p1.rank == p2.rank)
					p1.rank++;
			}
			else
				p1.parent = p2;
			return true;
		}
	}
	
	static class Node {
		int data;
		int rank;
		Node parent;
		
		public Node(int a) {
			data = a;
			rank = 0;
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