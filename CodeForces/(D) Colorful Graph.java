import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class zizo7 {
	static ArrayList<Integer> adjList[];
	static int n, m, colors[];
	static HashSet<Integer> neighbours[];
	static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		n = sc.nextInt();
		m = sc.nextInt();
		colors = new int[n];
		int idx = (int)1e5;
		for(int i = 0; i < n; i++) {
			int c = sc.nextInt();
			colors[i] = c;
			idx = Math.min(idx, c);
		}	
		adjList = new ArrayList[n];
		for(int i = 0; i < n; i++)
			adjList[i] = new ArrayList();
		neighbours = new HashSet[(int)1e5+1];
		for(int i = 0; i < (int)1e5+1; i++)
			neighbours[i] = new HashSet();
		visited = new boolean[n];
		for(int i = 0; i < m; i++) {
			int u = sc.nextInt()-1, v = sc.nextInt()-1;
			adjList[u].add(v);
			adjList[v].add(u);
		}
		preTraversal();
		int max = 0;
		for(int i = 0; i < (int)1e5+1; i++)
			if(neighbours[i].size() > max) {
				max = neighbours[i].size();
				idx = i;
			}
		out.println(idx);
		
		out.flush();
		out.close();
	}
	
	public static void preTraversal() {
		for(int i = 0; i < n; i++)
			if(!visited[i])
				dfs(i);
	}
	
	public static void dfs(int u) {
		visited[u] = true;
		for(int v:adjList[u]) {
			if(colors[u] != colors[v])
				neighbours[colors[u]].add(colors[v]);
			if(!visited[v]) {
				visited[v] = true;
				dfs(v);
			}
		}
	}
	
	static class Scanner {
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