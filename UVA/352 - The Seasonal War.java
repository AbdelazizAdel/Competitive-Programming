import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
	static int N, grid[][];
	static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1}; // N S E W NE NW SE SW
	static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1}; // N S E W NE NW SE SW
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		while(sc.ready()) {
			N = Integer.parseInt(sc.nextLine());
			grid = new int[N][N];
			for(int i = 0; i < N; i++) {
				String row = sc.nextLine();
				for(int j = 0; j < N; j++)
					grid[i][j] = Integer.parseInt(Character.toString(row.charAt(j)));
			}
			int count = 0;
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					if(grid[i][j] == 1) {
						dfs(i, j);
						count++;
					}
			out.printf("Image number %d contains %d war eagles.%n", T++, count);
		}
		out.flush();
		out.close();
	}
	
	public static void dfs(int x, int y) {
		grid[x][y] = 0;
		for(int i = 0; i < 8; i++) {
			int x2 = x + dx[i], y2 = y + dy[i];
			if(isValid(x2, y2 ) && grid[x2][y2] == 1)
				dfs(x2, y2);
		}
	}
	
	public static boolean isValid(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
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