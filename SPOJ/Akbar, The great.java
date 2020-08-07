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
	static int T, C, d[], o[];
	static ArrayList<Integer>[] adjList;
	public static void main(String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		T = sc.nextInt();
		while(T-->0) {
			int N = sc.nextInt(), R = sc.nextInt(), M = sc.nextInt();
			d = new int[N];
			o = new int[N];
			adjList = new ArrayList[N];
			C = 0;
			Arrays.fill(o, -1);
			for(int i = 0; i < N; i++)
				adjList[i] = new ArrayList<Integer>();
			for(int i = 0; i < R; i++) {
				int u = sc.nextInt() - 1;
				int v = sc.nextInt() - 1;
				adjList[u].add(v);
				adjList[v].add(u);
			}
			String ans = "Yes";
			for(int i = 0; i < M; i++) {
				boolean intersect = bfs(sc.nextInt() - 1, sc.nextInt());
				if(!intersect) {
					ans = "No";
					break;
				}
			}
			if(C < N)
				ans = "No";
			out.println(ans);
		}
		out.flush();
	}
	
	public static boolean bfs(int s, int k) {
		if(o[s] != -1)
			return false;
		o[s] = s;
		C++;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		if(k == 0)
			return true;
		while(!q.isEmpty()) {
			int u = q.poll();
			for(int v: adjList[u]) {
				if(o[v] != -1 && o[v] != s)
					return false;
				if(o[v] == -1) {
					d[v] = d[u] + 1;
					if(d[v] > k) {
						d[v] = 0;
						return true;
					}
					o[v] = s;
					q.add(v);
					C++;
				}
			}
		}
		return true;
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