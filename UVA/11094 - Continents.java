import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class zizo {
	static int N, M;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1}; // N S E W
	static char grid[][], land;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		while(sc.ready()) {
			M = sc.nextInt();
			N = sc.nextInt();
			grid = new char[M][N];
			for(int i = 0; i < M; i++) {
				String row = sc.nextLine();
				for(int j = 0; j < N; j++)
					grid[i][j] = row.charAt(j);
			}
			visited = new boolean[M][N];
			int x = sc.nextInt(), y = sc.nextInt();
			land = grid[x][y];
			dfs(x, y);
			int ans = 0;
			for(int i = 0; i < M; i++)
				for(int j = 0; j < N; j++)
					if(grid[i][j] == land && !visited[i][j])
						ans = Math.max(ans, dfs(i, j));
			out.println(ans);
			if(sc.ready())
				sc.nextLine();
		}
		out.flush();
		out.close();
	}
	
	public static int dfs(int x, int y) {
		visited[x][y] = true;
		int ans = 1;
		for(int i = 0; i < 4; i++) {
			int x2 = x + dx[i], y2 = y + dy[i] == -1 ? N - 1 : (y + dy[i] == N ? 0 : y + dy[i]);
			if(isValid(x2, y2) && grid[x2][y2] == land && !visited[x2][y2])
				ans+=dfs(x2, y2);
		}
		return ans;
	}
	
	public static boolean isValid(int x, int y) {
		return x >= 0 && x < M && y >= 0 && y < N;
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