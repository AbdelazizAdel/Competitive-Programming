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
		while (sc.ready()) {
			int N = sc.nextInt(), K = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
			SegmentTree tree = new SegmentTree(arr);
			tree.build();
			for (int i = 0; i < K; i++) {
				char c = sc.next().charAt(0);
				int x = sc.nextInt(), y = sc.nextInt();
				if (c == 'P') {
					int a = tree.getSign(x - 1, y - 1);
					out.print(a > 0 ? "+" : (a < 0 ? "-" : "0"));
				}
				else
					tree.update(x - 1, y);
			}
			out.println();
		}
		out.flush();
		out.close();
	}

	static class SegmentTree {
		int a[], t[];

		public SegmentTree(int[] arr) {
			a = arr;
			t = new int[a.length * 4];
		}
		
		public void build() {
			build(1, 0, a.length - 1);
		}
		
		public int getSign(int l, int r) {
			return getSign(1, 0, a.length - 1, l, r);
		}
		
		public void update(int pos, int new_val) {
			update(1, 0, a.length - 1, pos, new_val);
		}

		private void build(int v, int tl, int tr) {
			if (tl == tr)
				t[v] = a[tl] > 0 ? 1 : (a[tl] < 0 ? -1 : 0);
			else {
				int tm = (tl + tr) / 2;
				build(2 * v, tl, tm);
				build(2 * v + 1, tm + 1, tr);
				t[v] = t[2 * v] * t[2 * v + 1];
			}
		}

		private int getSign(int v, int tl, int tr, int l, int r) {
			if (l > r)
				return 1;
			if (tl == l && tr == r)
				return t[v];
			int tm = (tl + tr) / 2;
			return getSign(2 * v, tl, tm, l, Math.min(r, tm)) * getSign(2 * v + 1, tm + 1, tr, Math.max(tm + 1, l), r);
		}

		private void update(int v, int tl, int tr, int pos, int new_val) {
			if (tl == tr)
				t[v] = new_val > 0 ? 1 : (new_val < 0 ? -1 : 0);
			else {
				int tm = (tl + tr) / 2;
				if (pos <= tm)
					update(2 * v, tl, tm, pos, new_val);
				else
					update(2 * v + 1, tm + 1, tr, pos, new_val);
				t[v] = t[2 * v] * t[2 * v + 1];
			}
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