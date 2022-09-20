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
		int n = sc.nextInt(), m = sc.nextInt();
		TreeSet<Integer> set = new TreeSet();
		for(int i = 1; i <= n; i++)
			set.add(i);
		int[] ans = new int[n];
		for(int i = 0; i < m; i++) {
			int l = sc.nextInt(), r = sc.nextInt(), x = sc.nextInt();
			set.remove(x);
			Integer e = set.ceiling(l);
			while(!set.isEmpty() && e != null && e <= r) {
				ans[e - 1] = x;
				set.remove(e);
				e = set.ceiling(l);
			}
			set.add(x);
		}
		for(int i = 0; i < n; i++)
			out.print(ans[i] + (i == n - 1 ? "\n" : " "));
		out.flush();
		out.close();
	}
	
	static class SegmentTree {
		int a[], t[];
		
		public SegmentTree(int[] arr) {
			a = arr;
			t = new int[a.length * 4];
		}
		
		public void build(int v, int tl, int tr) {
			if(tl == tr)
				t[v] = a[tl];
			else {
				int tm = (tl + tr) / 2;
				build(2 * v, tl, tm);
				build(2 * v + 1, tm + 1, tr);
				t[v] = t[2 * v] + t[2 * v + 1];
			}
		}
		
		public int getSum(int v, int tl, int tr, int l, int r) {
			if(l > r)
				return 0;
			if(tl == l && tr == r)
				return t[v];
			int tm = (tl + tr) / 2;
			return getSum(2 * v, tl, tm, l, Math.min(r, tm)) +
				   getSum(2 * v + 1, tm + 1, tr, Math.max(tm + 1, l), r);
		}
		
		public void update(int v, int tl, int tr, int pos, int new_val) {
			if(tl == tr)
				t[v] = new_val;
			else {
				int tm = (tl + tr) / 2;
				if(pos <= tm)
					update(2 * v, tl , tm, pos, new_val);
				else
					update(2 * v + 1, tm + 1, tr, pos, new_val);
				t[v] = t[2 * v] + t[2 * v + 1];
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