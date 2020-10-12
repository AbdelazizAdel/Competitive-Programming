import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
	static ArrayList<Integer> adjList[];
	static int count, dfs_num[], dfs_low[];
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		while(true) {
			int N = sc.nextInt(), M = sc.nextInt();
			if(N == 0 && M == 0)
				break;
			adjList = new ArrayList[N];
			for(int i = 0; i < N; i++)
				adjList[i] = new ArrayList<Integer>();
			dfs_num = new int[N];
			dfs_low = new int[N];
			for(int i = 0; i < M; i++) {
				int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
				adjList[u].add(v);
				adjList[v].add(u);
			}
			count  = 0;
			findPoints(0, -1, 1);
			out.println(count);
		}
		
		out.flush();
		out.close();
	}

	
	public static void findPoints(int u, int p, int counter) {
		dfs_num[u] = dfs_low[u] = counter++;
		int children = 0;
		boolean counted = false;
		for(int v : adjList[u]) {
			if(dfs_num[v] == 0) {
				findPoints(v, u, counter);
				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
				if(dfs_low[v] >= dfs_num[u] && p != -1) {
					if(!counted) {
						count++;
						counted = true;
					}
				}
				children++;
			}
			else if(v != p)
				dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]);
		}
		if(p == -1 && children > 1)
			count++;
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