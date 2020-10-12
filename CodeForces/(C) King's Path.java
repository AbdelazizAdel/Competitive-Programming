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
		int x0 = sc.nextInt(), y0 = sc.nextInt(), x1 = sc.nextInt(), y1 = sc.nextInt(), n = sc.nextInt();
		int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
		int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
		HashMap<Integer, HashSet<Integer>> allowed = new HashMap();
		for(int i = 0; i < n; i++) {
			int r = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
			if(!allowed.containsKey(r))
				allowed.put(r, new HashSet<Integer>());
			for(int j = a; j <= b; j++)
				allowed.get(r).add(j);
		}
		TreeMap<Pair, Integer> d = new TreeMap();
		Queue<Pair> q = new LinkedList();
		q.add(new Pair(x0, y0));
		d.put(new Pair(x0, y0), 0);
		while(!q.isEmpty()) {
			Pair p = q.poll();
			for(int i = 0; i < 8; i++) {
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(isValid(nx, ny) && allowed.containsKey(nx) && allowed.get(nx).contains(ny) && !d.containsKey(new Pair(nx, ny))) {
					q.add(new Pair(nx, ny));
					d.put(new Pair(nx, ny), d.get(p) + 1);
				}
			}
		}
		out.println(d.containsKey(new Pair(x1, y1)) ? d.get(new Pair(x1, y1)) : -1);
		out.flush();
		out.close();
	}
	
	public static boolean isValid(int x, int y) {
		return x >= 0 && x < (int)1e9 && y >= 0 && y < (int)1e9;
	}
	
	static class Pair implements Comparable<Pair>{
		int x, y;
		
		public Pair(int a, int b) {
			x = a;
			y = b;
		}
		
		public int compareTo(Pair p) {
			if(x == p.x)
				return y - p.y;
			return x - p.x;
		}
		
		public String toString() {
			return x + " " + y;
		}
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