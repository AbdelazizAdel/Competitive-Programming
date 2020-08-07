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
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.lang.*;

public class zizo7 {
	static int T, d[];
	static boolean[] visited;
	static ArrayList<Integer>[] adjList;
	public static void main(String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		adjList = new ArrayList[64];
		for(int i = 0; i < 64; i++)
			adjList[i] = new ArrayList<Integer>();
		int[] dx = {2, 2, -2, -2, 1, -1, 1, -1};
		int[] dy = {1, -1, 1, -1, 2, 2, -2, -2};
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				for(int k = 0; k < 8; k++) {
					int x = i + dx[k], y = j + dy[k];
					if(inBounds(x, y))
						adjList[i * 8 + j].add(x * 8 + y);
				}
			}
		}
		T = sc.nextInt();
		while(T-->0) {
			d = new int[64];
			visited = new boolean[64];
			String a = sc.next(), b = sc.next();
			int s = (int)(a.charAt(0) - 'a') * 8 + Integer.parseInt(a.charAt(1) + "") - 1;
			int e = (int)(b.charAt(0) - 'a') * 8 + Integer.parseInt(b.charAt(1) + "") - 1;
			bfs(s, e);
			out.println(d[e]);
		}
		out.flush();
		
	}
	
	public static void bfs(int s, int e) {
		if(s == e)
			return;
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		visited[s] = true;
		while(!q.isEmpty()) {
			int u = q.poll();
			for(int v: adjList[u]) {
				if(!visited[v]) {
					visited[v] = true;
					q.add(v);
					d[v] = d[u] + 1;
					if(v == e)
						return;
				}
			}
		}
	}
	
	public static boolean inBounds(int x, int y) {
		return ((x >= 0 && x <= 7) && (y >= 0 && y <= 7));
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