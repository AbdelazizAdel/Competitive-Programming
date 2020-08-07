import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.lang.*;

public class zizo7 {
	static int grid[][], H, W, max = 0;
	static boolean visited[][];
	static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
	static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
	public static void main(String[] args) throws java.lang.Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = 1;
		while(true) {
			H = sc.nextInt();
			W = sc.nextInt();
			if(H == 0)
				break;
			grid = new int[H][W];
			visited = new boolean[H][W];
			max = 0;
			for(int i = 0; i < H; i++) {
				String[] arr = sc.nextLine().split("");
				for(int j = 0; j < W; j++)
					grid[i][j] = (int)(arr[j].charAt(0) - 'A');
			}
			for(int i = 0; i < H; i++)
				for(int j = 0; j < W; j++)
					if(grid[i][j] == 0 && !visited[i][j])
						dfs(i, j, 1);
			out.printf("Case %d: %d%n", t++, max);
		}
		out.flush();
	}
	
	static boolean inBounds(int x, int y) {
		return x >= 0 && x < H && y >= 0 && y < W;
	}
	
	static void dfs(int xs, int ys, int c) {
		visited[xs][ys] = true;
		for(int i = 0; i < 8; i++) {
			int x = xs + dx[i], y = ys + dy[i];
			if(inBounds(x, y) && !visited[x][y] && grid[x][y] == grid[xs][ys] + 1) {
				dfs(x, y, c + 1);
			}
		}
		max = Math.max(max, c);
	}
	
	static class Scanner {
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