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
		int t = sc.nextInt();
		while(t-- > 0) {
			String grid = sc.next() + sc.next() + sc.next();
			Queue<Pair> q = new LinkedList();
			q.add(new Pair(".........", 'X'));
			boolean x = true, found = false;
			while(!q.isEmpty()) {
				Pair u = q.poll();
				if(u.grid.equals(grid)) {
					found = true;
					break;
				}
				if(check(u.grid))
					continue;
				for(int i = 0; i < 9; i++) {
					if(u.grid.charAt(i) != '.')
						continue;
					if(grid.charAt(i) == u.c) {
						Pair temp = new Pair(u.grid.substring(0, i) + u.c + u.grid.substring(i + 1), u.c == 'X' ? 'O' : 'X');
						q.add(temp);
					}
				}
			}
			out.println(found ? "yes" : "no");
		}
		out.flush();
		out.close();
	}
	
	static class Pair {
		String grid;
		char c;
		
		public Pair(String a, char b) {
			grid = a;
			c = b;
		}
	}
	
	public static boolean check(String grid) {
		boolean rows = false, cols = false, diagonals = false;
		for(int i = 0; i < 3; i++) {
			rows|=(grid.charAt(3 * i) != '.' && grid.charAt(3 * i) == grid.charAt(3 * i + 1) && grid.charAt(3 * i + 1) == grid.charAt(3 * i + 2));
			cols|=(grid.charAt(i) != '.' && grid.charAt(i) == grid.charAt(i + 3) && grid.charAt(i + 3) == grid.charAt(i + 6));
		}
		diagonals = (grid.charAt(0) != '.' && grid.charAt(0) == grid.charAt(4) && grid.charAt(4) == grid.charAt(8)) ||
				(grid.charAt(2) != '.' && grid.charAt(2) == grid.charAt(4) && grid.charAt(4) == grid.charAt(6));
		return rows || cols || diagonals;
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