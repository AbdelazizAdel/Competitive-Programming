import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class zizo {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int m = sc.nextInt(), n = sc.nextInt();
		int[][] mat = new int[m][n], ans = new int[m][n];
		boolean[][] safe = new boolean[m][n];
		for(int i = 0; i < m; i++)
			for(int j = 0; j < n; j++)
				mat[i][j] = sc.nextInt();
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(mat[i][j] == 0) {
					safe[i][j] = true;
					continue;
				}
				safe[i][j] = safe[i][j] ? true : check(i, j, mat);
				if(check(i, j, mat)) {
					makeSafe(i, j, safe);
					ans[i][j] = 1;
				}
			}
		}
		boolean mistake = true;
		for(int i = 0; i < m; i++)
			for(int j = 0; j < n; j++)
				mistake&=safe[i][j];
		if(!mistake)
			out.println("NO");
		else {
			out.println("YES");
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++)
					out.print(ans[i][j] + (j == n - 1 ? "" : " "));
				out.println();
			}
		}
		out.flush();
		out.close();
	}

	public static boolean check(int r, int c, int[][] mat) {
		for (int i = 0; i < mat[0].length; i++)
			if (mat[r][i] == 0)
				return false;
		for (int i = 0; i < mat.length; i++)
			if (mat[i][c] == 0)
				return false;
		return true;
	}

	public static void makeSafe(int r, int c, boolean[][] safe) {
		for (int i = 0; i < safe[0].length; i++)
			safe[r][i] = true;
		for (int i = 0; i < safe.length; i++)
			safe[i][c] = true;
	}

	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}