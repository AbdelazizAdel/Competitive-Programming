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
		int T = 1;
		while(sc.ready()) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
			SegmentTree tree = new SegmentTree(arr);
			tree.build();
			TreeMap<Integer, Integer> map = new TreeMap();
			int ans = 0;
			for(int i = 0; i < N; i++) {
				if(arr[i] == 0) {
					map.put(arr[i], i);
					continue;
				}
				if(!map.containsKey(arr[i]))
					ans++;
				else {
					int idx = map.get(arr[i]);
					int min = tree.getMin(idx, i);
					if(min < arr[i])
						ans++;
				}
				map.put(arr[i], i);
			}
			out.printf("Case %d: %d%n", T++, ans);
		}
		out.flush();
		out.close();
	}

	static class SegmentTree {
		int a[], t[], lazy[];
		
		public SegmentTree(int[] arr) {
			a = arr;
			t = new int[a.length * 4];
			Arrays.fill(t, Integer.MAX_VALUE);
			lazy = new int[a.length * 4];
		}
		
		public void build() { build(1, 0, a.length - 1); }
		
		public int getMin(int l, int r) { return getMin(1, 0, a.length - 1, l, r); }
		
		public void update(int l, int r, long addend) { update(1, 0, a.length - 1, l, r, addend); }
		
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
			push(v);
			int tm = (tl + tr) / 2;
			return Math.min(getMin(2 * v, tl, tm, l, Math.min(tm, r)), getMin(2 * v + 1, tm + 1, tr, Math.max(tm + 1, l), r));
		}
		
		private void update(int v, int tl, int tr, int l, int r, long addend) {
			if(l > r)
				return;
			if(l == tl && r == tr) {
				t[v]+=addend;
				lazy[v]+=addend;
			}
			else {
				push(v);
				int tm = (tl + tr) / 2;
				update(2 * v, tl, tm, l, Math.min(tm, r), addend);
				update(2 * v + 1, tm + 1, tr, Math.max(tm + 1, l), r, addend);
				t[v] = Math.min(t[2 * v], t[2 * v + 1]);
			}
		}
		
		private void push(int v) {
			if(lazy[v] != 0) {
				lazy[2 * v]+=lazy[v];
				t[2 * v]+=lazy[v] ;
				lazy[2 * v + 1]+=lazy[v];
				t[2 * v + 1]+=lazy[v];
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