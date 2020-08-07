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
	static int n;
	static boolean visited[];
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		while(true) {
			n = sc.nextInt();
			if(n == 0)
				break;
			adjList = new ArrayList[n];
			for(int i = 0; i < n; i++)
				adjList[i] = new ArrayList();
			String s = "";
			while(!(s = sc.nextLine()).equals("0")) {
				StringTokenizer st = new StringTokenizer(s);
				int u = Integer.parseInt(st.nextToken());
				while(st.hasMoreTokens()) {
					int v = Integer.parseInt(st.nextToken());
					if(v == 0)
						break;
					adjList[u-1].add(v-1);
				}
			}
			int n = sc.nextInt();
			for(int i = 0; i < n; i++) {
				visited = new boolean[zizo7.n];
				int root = sc.nextInt()-1;
				dfs(root);
				int num = 0;
				StringBuilder sb = new StringBuilder();
				for(int j = 0; j < zizo7.n; j++) {
					if(!visited[j]) {
						sb.append((j+1)+" ");
						num++;
					}
				}
					
				out.println(num==0?num:num+" "+sb.deleteCharAt(sb.length()-1).toString());
			}
		}
		
		out.flush();
		out.close();
	}
	
	public static void dfs(int u) {
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