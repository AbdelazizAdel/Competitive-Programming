import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class zizo {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt(), m = sc.nextInt();
		ArrayList<Integer>[] adjList = new ArrayList[2 * Math.max(n, m)];
		for(int i = 0; i < adjList.length; i++)
			adjList[i] = new ArrayList<Integer>();
		for(int i = 1; i < adjList.length; i++) {
			if(i - 1 > 0)
				adjList[i].add(i - 1);
			if(2 * i < adjList.length)
				adjList[i].add(2  *i);
		}
		int[] dis = new int[adjList.length];
		Arrays.fill(dis, -1);
		Queue<Integer> q = new LinkedList();
		q.add(n);
		dis[n] = 0;
		while(!q.isEmpty()) {
			int u = q.poll();
			for(int v : adjList[u])
				if(dis[v] == -1) {
					q.add(v);
					dis[v] = dis[u] + 1;
				}
		}
		out.println(dis[m]);
		out.flush();
		out.close();
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