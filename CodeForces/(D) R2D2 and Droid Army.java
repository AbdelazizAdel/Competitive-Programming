import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
		int[][] arr = new int[n][m];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < m; j++)
				arr[i][j] = sc.nextInt();
		SegmentTree tree = new SegmentTree(arr);
		tree.build(1, 0, n - 1);
		int[] ans = null;
		int low = 0, high = n;
		while(low <= high) {
			int mid = (low + high) / 2;
			boolean found = false;
			for(int i = 0; i <= n - mid; i++) {
				int[] a = tree.getMax(1, 0, n - 1, i, i + mid - 1);
				if(sum(a) <= k) {
					ans = a;
					found = true;
					break;
				}
			}
			if(found)
				low = mid + 1;
			else
				high = mid - 1;
		}
		for(int i = 0; i < ans.length; i++)
			out.print(ans[i] + (i == ans.length - 1 ? "\n" : " "));
		out.flush();
		out.close();
	}
	
	public static int sum(int[] arr) {
		int sum = 0;
		for(int i = 0; i < arr.length; i++)
			sum+=arr[i];
		return sum;
	}

	static class SegmentTree {
		int a[][], t[][];
		int m;
		final int MIN = 0;
		public SegmentTree(int[][] x) {
			a = x;
			m = x[0].length;
			t = new int[x.length * 4][m];
		}
		
		private void build(int v, int tl, int tr) {
			if(tl == tr) {
				for(int i = 0; i < m; i++)
					t[v][i] = a[tl][i];
			}
			else {
				int tm = (tl + tr) / 2;
				build(2 * v, tl, tm);
				build(2 * v + 1, tm + 1, tr);
				for(int i = 0; i < m; i++)
					t[v][i] = Math.max(t[2 * v][i], t[2 * v + 1][i]);
			}
		}
		
		private int[] getMax(int v, int tl, int tr, int l, int r) {
			if(l > r) {
				int[] arr = new int[m];
				Arrays.fill(arr, MIN);
				return arr;
			}
			if(l == tl && r == tr)
				return t[v];
			int tm = (tl + tr) / 2;
			int[] left = getMax(2 * v, tl, tm, l, Math.min(r, tm));
			int[] right = getMax(2 * v + 1, tm + 1, tr, Math.max(tm + 1, l), r);
			int[] ans = new int[m];
			for(int i = 0; i < m; i++)
				ans[i] = Math.max(left[i], right[i]);
			return ans;
		}
		
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