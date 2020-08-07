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
	static boolean[] isAcron, visited;
	static int trees, acrons, V;
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		while(t-->0) {
			trees = acrons = 0;
			StringBuilder sb = new StringBuilder();
			String s = "";
			while((s = sc.nextLine()).charAt(0) != '*')
				sb.append(s+"\n");
			StringTokenizer st = new StringTokenizer(sc.nextLine(), ",");
			V = st.countTokens();
			adjList = new ArrayList[V];
			isAcron = new boolean[V];
			visited = new boolean[V];
			int mapping[] = new int['Z'+1];
			for(int i = 0; i < V; i++)
				mapping[st.nextToken().charAt(0)] = i;
			for(int i = 0; i < V; i++)
				adjList[i] = new ArrayList<Integer>();
			st = new StringTokenizer(sb.toString(), "\n");
			while(st.hasMoreTokens()) {
				String e = st.nextToken();
				adjList[mapping[e.charAt(1)]].add(mapping[e.charAt(3)]);
				adjList[mapping[e.charAt(3)]].add(mapping[e.charAt(1)]);
			}
			for(int i = 0; i < V; i++)
				if(adjList[i].size() == 0) {
					acrons++;
					isAcron[i] = true;
				}
			preTraversal();
			out.println("There are "+trees+" tree(s) and "+acrons+" acorn(s).");
		}
		
		out.flush();
		out.close();
	}
	
	public static void preTraversal() {
		for(int i = 0; i < V; i++)
			if(!visited[i] && !isAcron[i]) {
				trees++;
				dfs(i);
			}
	}
	
	public static void dfs(int u) {
		visited[u] = true;
		for(int v:adjList[u])
			if(!visited[v]) {
				visited[v] = true;
				dfs(v);
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