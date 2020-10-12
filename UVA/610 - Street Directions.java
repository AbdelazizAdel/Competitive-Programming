import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class zizo {
	static ArrayList<Integer> adjList[];
	static int[] dfs_num, dfs_low;
	static PrintWriter out = new PrintWriter(System.out);
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = 1;
		while(true) {
			int n = sc.nextInt(), m = sc.nextInt();
			if(n == 0)
				break;
			adjList = new ArrayList[n];
			dfs_num = new int[n];
			dfs_low = new int[n];
			for(int i = 0; i < n; i++)
				adjList[i] = new ArrayList<Integer>();
			for(int i = 0; i < m; i++) {
				int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
				adjList[u].add(v);
				adjList[v].add(u);
			}
			out.println(t++ + "\n");
			findBridges(0, -1, 0, new TreeSet<Pair>());
			out.println('#');
		}
		out.flush();
		out.close();
	}

	public static void findBridges(int u, int p, int counter, TreeSet<Pair> set) {
		dfs_num[u] = dfs_low[u] = ++counter;
		for(int v : adjList[u]) {
			if(dfs_num[v] == 0) {
				findBridges(v, u, counter, set);
				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
				out.println(u + 1 + " " + (v + 1));
				if(dfs_low[v] > dfs_num[u])
					out.println(v + 1 + " " + (u + 1));
			}
			else if(v != p) {
				if(!set.contains(new Pair(u, v))) {
					out.println(u + 1 + " " + (v + 1));
					dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]);
					set.add(new Pair(v, u));
				}
			}
		}
	}

	static class Pair implements Comparable<Pair> {
		int a, b;

		public Pair(int x, int y) {
			a = x;
			b = y;
		}
		@Override
		public int compareTo(Pair x) {
			return a - x.a == 0 ? (b - x.b == 0 ? 0 : b - x.b) : a - x.a;
		}

		public boolean equals(Object o) {
			Pair x = (Pair) o;
			return a == x.a && b == x.b;
		}

		public String toString() {
			return a + " " + b;
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