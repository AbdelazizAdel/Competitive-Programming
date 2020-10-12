import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		while(true) {
			int n = sc.nextInt(), m = sc.nextInt();
			if(n == 0 && m == 0)
				break;
			adjList = new ArrayList[n];
			visited = new boolean[n];
			for(int i = 0; i < n; i++)
				adjList[i] = new ArrayList<Integer>();
			for(int i = 0; i < m; i++)
				adjList[sc.nextInt() - 1].add(sc.nextInt() - 1);
			LinkedList<Integer> ans = new LinkedList<>();
			for(int i = 0; i < n; i++)
				if(!visited[i])
					topological_sort(i, ans);
			int idx = 0;
			for(int e : ans) {
				out.print(e + (idx == n - 1 ? "\n" : " "));
				idx++;
			}	
		}
		out.flush();
		out.close();
	}

	public static void topological_sort(int u, LinkedList<Integer> list) {
		visited[u] = true;
		for(int v : adjList[u])
			if(!visited[v])
				topological_sort(v, list);
		list.addFirst(u + 1);
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