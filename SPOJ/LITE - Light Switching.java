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
		int N = sc.nextInt(), M = sc.nextInt();
		int[] arr = new int[N];
		SegmentTree tree = new SegmentTree(arr);
		tree.build();
		while(M-- > 0) {
			int type = sc.nextInt();
			if(type == 0)
				tree.update(sc.nextInt() - 1, sc.nextInt() - 1);
			else
				out.println(tree.getSum(sc.nextInt() - 1, sc.nextInt() - 1));
		}
		out.flush();
		out.close();
	}

	static class SegmentTree {
		int a[], t[], lazy[];
		
		public SegmentTree(int[] arr) {
			a = arr;
			t = new int[a.length * 4];
			lazy = new int[a.length * 4];
		}
		
		public void build() { build(1, 0, a.length - 1); }
		
		public int getSum(int l, int r) { return getSum(1, 0, a.length - 1, l, r); }
		
		public void update(int l, int r) { update(1, 0, a.length - 1, l, r); }
		
		private void build(int v, int tl, int tr) {
			if(tl == tr)
				t[v] = a[tl];
			else {
				int tm = (tl + tr) / 2;
				build(2 * v, tl, tm);
				build(2 * v + 1, tm + 1, tr);
				t[v] = t[2 * v] + t[2 * v + 1];
			}
		}
		
		private int getSum(int v, int tl, int tr, int l, int r) {
			if(l > r)
				return 0;
			if(l == tl && r == tr)
				return t[v];
			push(v, tl, tr);
			int tm = (tl + tr) / 2;
			return getSum(2 * v, tl, tm, l, Math.min(tm, r)) + getSum(2 * v + 1, tm + 1, tr, Math.max(tm + 1, l), r);
		}
		
		private void update(int v, int tl, int tr, int l, int r) {
			if(l > r)
				return;
			if(l == tl && r == tr) {
				t[v] = tr - tl + 1 - t[v];
				lazy[v] = 1 - lazy[v];
			}
			else {
				push(v, tl, tr);
				int tm = (tl + tr) / 2;
				update(2 * v, tl, tm, l, Math.min(tm, r));
				update(2 * v + 1, tm + 1, tr, Math.max(tm + 1, l), r);
				t[v] = t[2 * v] + t[2 * v + 1];
			}
		}
		
		private void push(int v, int tl, int tr) {
			if(lazy[v] == 1) {
				int tm = (tl + tr) / 2;
				lazy[2 * v] = 1 - lazy[2 * v];
				t[2 * v] = tm - tl + 1 - t[2 * v] ;
				lazy[2 * v + 1] = 1 - lazy[2 * v + 1];
				t[2 * v + 1] = tr - tm - t[2 * v + 1] ;
				lazy[v] = 0;
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

		public long nextint() throws IOException {
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