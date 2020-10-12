import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
	static ArrayList<Integer> adjList[];
	static int dfs_num[], dfs_low[];
	static HashSet<Integer> set;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = 1, n = sc.nextInt();
		while(true) {
			if(n == 0)
				break;
			String[] arr = new String[n];
			for(int i = 0; i < n; i++)
				arr[i] = sc.nextLine();
			Arrays.sort(arr);
			adjList = new ArrayList[n];
			dfs_num = new int[n];
			dfs_low = new int[n];
			Arrays.fill(dfs_num, -1);
			Arrays.fill(dfs_low, -1);
			for(int i = 0; i < n; i++)
				adjList[i] = new ArrayList<Integer>();
			int m = sc.nextInt();
			for(int i = 0; i < m; i++) {
				String u = sc.next(), v = sc.next();
				int a = Arrays.binarySearch(arr, u), b = Arrays.binarySearch(arr, v);
				adjList[a].add(b);
				adjList[b].add(a);
			}
			set = new HashSet();
			for(int i = 0; i < n; i++)
				if(dfs_num[i] == -1)
					articulationPoint(i, -1, 0);
			out.printf("City map #%d: %d camera(s) found%n", t++, set.size());
			ArrayList<Integer> ans = new ArrayList();
			for(int a : set)
				ans.add(a);
			Collections.sort(ans);
			for(int a : ans)
				out.println(arr[a]);
			n = sc.nextInt();
			if(n != 0)
				out.println();
		}
		out.flush();
		out.close();
	}
	
	public static void articulationPoint(int u, int p, int counter) {
		dfs_num[u] = dfs_low[u] = ++counter;
		int children = 0;
		for(int v : adjList[u]) {
			if(dfs_num[v] == -1) {
				articulationPoint(v, u, counter);
				dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
				children++;
				if(p != -1 && dfs_low[v] >= dfs_num[u])
					set.add(u);
			}
			else if(p != -1) {
				dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]);
			}
		}
		if(p == -1 && children > 1)
			set.add(u);
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