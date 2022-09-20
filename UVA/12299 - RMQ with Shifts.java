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
		int n = sc.nextInt(), q = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		SegmentTree tree = new SegmentTree(arr);
		tree.build();
		while(q-- > 0) {
			StringTokenizer st = new StringTokenizer(sc.nextLine(), "[(,)]");
			String type = st.nextToken();
			if(type.equals("shift")) {
				int[] idxs = new int[st.countTokens()];
				for(int i = 0; i < idxs.length; i++)
					idxs[i] = Integer.parseInt(st.nextToken()) - 1;
				int first = arr[idxs[0]];
				for(int i = 1; i < idxs.length; i++)
					arr[idxs[i - 1]] = arr[idxs[i]];
				arr[idxs[idxs.length - 1]] = first;
				for(int i = 0; i < idxs.length; i++)
					tree.update(idxs[i], arr[i]);
			}
			else
				out.println(tree.getMin(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1));
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
		
		public int getMin(int l, int r) { return getMin(1, 0, a.length - 1, l, r); }
		
		public void update(int pos, int new_val) { update(1, 0, a.length - 1, pos, new_val); }
		
		private void build(int v, int tl, int tr) {
			if(tl == tr)
				t[v] = a[tl];
			else {
				int tm = (tl + tr) / 2;
				build(2 * v, tl, tm);
				build(2 * v + 1, tm + 1, tr);
				t[v] = Math.min(t[2 * v], t[2 * v + 1]);
			}
		}
		
		private int getMin(int v, int tl, int tr, int l, int r) {
			if(l > r)
				return Integer.MAX_VALUE;
			if(l == tl && r == tr)
				return t[v];
			int tm = (tl + tr) / 2;
			return Math.min(getMin(2 * v, tl, tm, l, Math.min(tm, r)), getMin(2 * v + 1, tm + 1, tr, Math.max(tm + 1, l), r));
		}
		
		private void update(int v, int tl, int tr, int pos, int new_val) {
			if(tl == tr)
				t[v] = a[tl];
			else {
				int tm = (tl + tr) / 2;
				if(pos <= tm)
					update(2 * v, tl , tm, pos, new_val);
				else
					update(2 * v + 1, tm + 1, tr, pos, new_val);
				t[v] = Math.min(t[2 * v], t[2 * v + 1]);
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