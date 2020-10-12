import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class zizo {
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt(), m = sc.nextInt();
		adjList = new ArrayList[n];
		for(int i = 0; i < n; i++)
			adjList[i] = new ArrayList<Integer>();
		visited = new boolean[n];
		for(int i = 0; i < m; i++) {
			int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
			adjList[u].add(v);
			adjList[v].add(u);
		}
		int num = 0;
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				dfs(i);
				num++;
			}
		}
		long ans = (long) 1 << (n - num);
		out.println(ans);
		out.flush();
		out.close();
	}
	
	public static void dfs(int u) {
		visited[u] = true;
		for(int v : adjList[u])
			if(!visited[v])
				dfs(v);
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