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
			int N = sc.nextInt();
			Pair[] pos = new Pair[N];
			for(int i = 0; i < N; i++)
				pos[i] = new Pair(sc.nextInt(), sc.nextInt());
			int M = sc.nextInt();
			UnionFind uf = new UnionFind();
			for(int i = 0; i < N; i++)
				uf.makeSet(i);
			for(int i = 0; i < M; i++)
				uf.union(sc.nextInt() - 1, sc.nextInt() - 1);
			Edge[] edges = new Edge[N * (N - 1) / 2];
			int idx = 0;
			for(int i = 0; i < N; i++)
				for(int j = i + 1; j < N; j++) {
					int w = (pos[i].x - pos[j].x) * (pos[i].x - pos[j].x) + (pos[i].y - pos[j].y) * (pos[i].y - pos[j].y);
					edges[idx++] = new Edge(i, j, w);
				}
			Arrays.sort(edges);
			if(uf.size == 1)
				out.println("No new highways need");
			for(int i = 0; i < edges.length && uf.size > 1; i++) {
				if(uf.findSet(edges[i].u) == uf.findSet(edges[i].v))
					continue;
				uf.union(edges[i].u , edges[i].v);
				out.printf("%d %d%n", edges[i].u + 1, edges[i].v + 1);
			}
			if(T != 0)
				out.println();
		}
		out.flush();
		out.close();
	}
	
	static class Pair{
		int x, y;
		
		public Pair(int a, int b) {
			x = a;
			y = b;
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
		HashMap<Integer, Node> map = new HashMap();
		int size;
		
		public void makeSet(int data) {
			Node n = new Node(data);
			map.put(data, n);
			size++;
		}
		
		public int findSet(int data) { return findSet(map.get(data)).data; }
		
		public Node findSet(Node n) {
			if(n == n.p)
				return n;
			return n.p = findSet(n.p);
		}
		
		public void union(int x, int y) {
			if(findSet(x) == findSet(y))
				return;
			Node n1 = findSet(map.get(x)), n2 = findSet(map.get(y));
			if(n1.rank >= n2.rank) {
				n2.p = n1;
				if(n1.rank == n2.rank)
					n1.rank++;
			}
			else
				n1.p = n2;
			size--;
		}
	}
	
	static class Node {
		Node p;
		int data;
		int rank;
		
		public Node(int a) {
			p = this;
			data = a;
			rank = 0;
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

		public double nextDouble() throws IOException{return Double.parseDouble(next());}

		public boolean ready() throws IOException {return br.ready();}

	}
}