import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class Solution {
	static HashSet<Integer> primes = new HashSet<Integer>();
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		generatePrimes(1000_000);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int n = sc.nextInt(), q = sc.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i < n; i++)
				arr[i] = sc.nextInt();
			SegmentTree tree = new SegmentTree(arr);
			tree.build();
			out.printf("Case %d:%n", t);
			for(int i = 0; i < q; i++) {
				int type = sc.nextInt();
				if(type == 0)
					tree.update(sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt());
				else
					out.println(tree.getCount(sc.nextInt() - 1, sc.nextInt() - 1));
			}
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
		
		public int getCount(int l, int r) { return getCount(1, 0, a.length - 1, l, r); }
		
		public void update(int l, int r, int new_val) { update(1, 0, a.length - 1, l, r, new_val); }
		
		private void build(int v, int tl, int tr) {
			if(tl == tr)
				t[v] = primes.contains(a[tl]) ? 1 : 0;
			else {
				int tm = (tl + tr) / 2;
				build(2 * v, tl, tm);
				build(2 * v + 1, tm + 1, tr);
				t[v] = t[2 * v] + t[2 * v + 1];
			}
		}
		
		private int getCount(int v, int tl, int tr, int l, int r) {
			if(l > r)
				return 0;
			if(l == tl && r == tr)
				return t[v];
			push(v, tl, tr);
			int tm = (tl + tr) / 2;
			return getCount(2 * v, tl, tm, l, Math.min(tm, r)) + getCount(2 * v + 1, tm + 1, tr, Math.max(tm + 1, l), r);
		}
		
		private void update(int v, int tl, int tr, int l, int r, int new_val) {
			if(l > r)
				return;
			if(l == tl && r == tr) {
				t[v] = primes.contains(new_val) ? tr - tl + 1 : 0;
				lazy[v] = new_val;
			}
			else {
				push(v, tl, tr);
				int tm = (tl + tr) / 2;
				update(2 * v, tl, tm, l, Math.min(tm, r), new_val);
				update(2 * v + 1, tm + 1, tr, Math.max(tm + 1, l), r, new_val);
				t[v] = t[2 * v] + t[2 * v + 1];
			}
		}
		
		
		private void push(int v, int tl, int tr) {
			if(lazy[v] != 0) {
				boolean isPrime = primes.contains(lazy[v]);
				int tm = (tl + tr) / 2;
				lazy[2 * v] = lazy[v];
				t[2 * v] = isPrime ? (tm - tl + 1) : 0;
				lazy[2 * v + 1] = lazy[v];
				t[2 * v + 1] = isPrime ? (tr - tm) : 0;
				lazy[v] = 0;
			}
		}
		
	}
	
	public static void generatePrimes(int n) {
		boolean[] isComposite = new boolean[n + 1];
		isComposite[0] = isComposite[1] = true;
		for(int i = 2; i * i <= n; i++)
			if(!isComposite[i])
				for(int j = i; i * j <= n; j++)
					isComposite[i * j] = true;
		for(int i = 0; i <= n; i++)
			if(!isComposite[i])
				primes.add(i);
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