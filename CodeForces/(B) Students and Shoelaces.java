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
		TreeSet<Integer>[] adjList = new TreeSet[n];
		for(int i = 0; i < n; i++)
			adjList[i] = new TreeSet<Integer>();
		for(int i = 0; i < m; i++) {
			int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
			adjList[u].add(v);
			adjList[v].add(u);
		}
		int cnt = 0;
		while(true) {
			ArrayList<Integer> list = new ArrayList();
			for(int i = 0; i < n; i++) {
				if(adjList[i].size() != 1)
					continue;
				list.add(i);
			}
			if(list.size() == 0)
				break;
			for(int e : list) {
				if(adjList[e].size() == 0)
					continue;
				int v = adjList[e].pollFirst();
				adjList[e].clear();
				adjList[v].remove(e);
			}
			cnt++;
		}
		out.println(cnt);
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