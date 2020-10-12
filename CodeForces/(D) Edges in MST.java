import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class zizo {
	static HashMap<Integer, ArrayList<Triple>> map;
	static HashMap<Integer, Integer> dfs_num, dfs_low;
	static HashSet<Integer> set;
	static String[] ans;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int N = sc.nextInt(), M = sc.nextInt();
		Edge[] edges = new Edge[M];
		for(int i = 0; i < M; i++ )
			edges[i] = new Edge(sc.nextInt() - 1, sc.nextInt() - 1, i, sc.nextInt());
		Arrays.sort(edges);
		ans = new String[M];
		UnionFind uf = new UnionFind();
		for(int i = 0; i < N; i++)
			uf.makeSet(i);
		int val = edges[0].w;
		for(int i = 0; i < M; i++) {
			map = new HashMap();
			dfs_num = new HashMap();
			dfs_low = new HashMap();
			set = new HashSet();
			int j = i;
			while(j < M && val == edges[j].w) {
				int u = uf.findSet(edges[j].u), v = uf.findSet(edges[j].v);
				if(u == v)
					ans[edges[j].idx] = "none";
				else {
					if(!map.containsKey(u)) {
						ArrayList<Triple> list = new ArrayList<Triple>();
						list.add(new Triple(v, edges[j].idx, edges[j].w));
						map.put(u, list);
					}
					else
						map.get(u).add(new Triple(v, edges[j].idx, edges[j].w));
					if(!map.containsKey(v)) {
						ArrayList<Triple> list = new ArrayList<Triple>();
						list.add(new Triple(u, edges[j].idx, edges[j].w));
						map.put(v, list);
					}
					else
						map.get(v).add(new Triple(u, edges[j].idx, edges[j].w));
				}
				j++;
			}
			for(int x : map.keySet())
				if(!dfs_num.containsKey(x))
					findBridges(x, -1, 0);
			if(j != M)
				val = edges[j].w;
			while(i < j) {
				uf.union(edges[i].u, edges[i].v);
				i++;
			}
			i--;
		}
		for(int i = 0; i < ans.length; i++)
			out.println(ans[i] == null ? "at least one" : ans[i]);
		out.flush();
		out.close();
	}
	
	public static void findBridges(int u, int p, int c) {
		dfs_num.put(u, c);
		dfs_low.put(u, c);
		c++;
		for(Triple t : map.get(u)) {
			if(!dfs_num.containsKey(t.v)) {
				set.add(t.idx);
				findBridges(t.v, u, c);
				dfs_low.put(u, Math.min(dfs_low.get(u), dfs_low.get(t.v)));
				if(dfs_low.get(t.v) > dfs_num.get(u))
					ans[t.idx] = "any";
			}
			else if(!set.contains(t.idx))
				dfs_low.put(u, Math.min(dfs_low.get(u), dfs_num.get(t.v)));
		}
	}

	static class Triple implements Comparable<Triple>{
		int v, idx, w;

		public Triple(int a, int b, int c) {
			v = a;
			idx = b;
			w = c;
		}
		
		public String toString() {
			return v + " " + idx + " " + w;
		}
		
		public int compareTo(Triple t) {return idx - t.idx;}
	}

	static class Edge implements Comparable<Edge> {
		int u, v, idx, w;

		public Edge(int a, int b, int c, int d) {
			u = a;
			v = b;
			idx = c;
			w = d;
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
				p1.size+=p2.size;
			}
			else {
				p1.parent = p2;
				p2.size+=p1.size;
			}
			return true;
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

		public double nextDouble() throws IOException{return Double.parseDouble(next());}

		public boolean ready() throws IOException {return br.ready();}

	}
}