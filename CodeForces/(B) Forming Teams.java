import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
	static ArrayList<Integer>[] adjList;
	static int[] color;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt(), m = sc.nextInt();
		adjList = new ArrayList[n];
		for(int i = 0; i < n; i++)
			adjList[i] = new ArrayList<Integer>();
		color = new int[n];
		Arrays.fill(color, -1);
		for(int i = 0; i < m; i++) {
			int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
			adjList[u].add(v);
			adjList[v].add(u);
		}
			
		int ans = 0;
		for(int i = 0; i < n; i++)
			if(color[i] == -1)
				ans+=bfs(i);
		if((n - ans) % 2 == 1)
			ans+=1;
		System.out.println(ans);
	}
	
	public static int bfs(int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		color[s] = 0;
		while(!q.isEmpty()) {
			int u = q.poll();
			for(int v : adjList[u]) {
				if(color[v] == -1) {
					color[v] = 1 - color[u];
					q.add(v);
				}
				else if(color[v] == color[u])
					return 1;
			}
		}
		return 0;
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