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
		Thread.sleep(3000);
		int[] dx = {-1, 1, -1, 1, -2, -2, 2, 2};
		int[] dy = {2, 2, -2, -2, 1, -1, 1, -1};
		while(sc.ready()) {
			String s = sc.next(), e = sc.next();
			int x1 = Integer.parseInt(s.charAt(1) + "") - 1, y1 = s.charAt(0) - 'a', x2 = Integer.parseInt(e.charAt(1) + "") - 1, y2 = e.charAt(0) - 'a';
			int[][] d = new int[8][8];
			for(int[] arr : d)
				Arrays.fill(arr, -1);
			Queue<Pair> q = new LinkedList();
			q.add(new Pair(x1, y1));
			d[x1][y1] = 0;
			while(!q.isEmpty()) {
				Pair u = q.poll();
				for(int i = 0; i < 8; i++) {
					int nx = u.x + dx[i], ny = u.y + dy[i];
					if(isValid(nx, ny) && d[nx][ny] == -1) {
						q.add(new Pair(nx, ny));
						d[nx][ny] = d[u.x][u.y] + 1;
					}
				}
			}
			out.printf("To get from %s to %s takes %d knight moves.%n", s, e, d[x2][y2]);
		}
		out.flush();
		out.close();
	}
	
	public static boolean isValid(int x, int y) {
		return x >= 0 && x < 8 && y >= 0 && y < 8;
	}
	
	static class Pair {
		int x, y;
		
		public Pair(int a, int b) {
			x = a;
			y = b;
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