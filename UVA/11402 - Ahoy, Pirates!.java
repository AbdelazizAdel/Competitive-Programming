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
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int M = sc.nextInt();
			int[] arr = new int[3 * 1000000];
			int idx = 0;
			while(M-- > 0) {
				int num = sc.nextInt();
				String s = sc.nextLine();
				for(int i = 0; i < num; i++)
					for(int j = 0; j < s.length(); j++)
						arr[idx++] = Integer.parseInt(s.charAt(j) + "");
			}
			SegmentTree tree = new SegmentTree(arr, idx);
			tree.build(1, 0, idx - 1);
			out.printf("Case %d:%n", t);
			int Q = sc.nextInt();
			int q = 1;
			for(int i = 1; i <= Q; i++) {
				String type = sc.next();
				if(type.equals("F"))
					tree.update(1, 0, idx - 1, sc.nextInt(), sc.nextInt(), 1);
				else if(type.equals("E"))
					tree.update(1, 0, idx - 1, sc.nextInt(), sc.nextInt(), 0);
				else if(type.equals("I"))
					tree.update(1, 0, idx - 1, sc.nextInt(), sc.nextInt(), 2);
				else
					out.printf("Q%d: %d%n", q++, tree.getSum(1, 0, idx - 1, sc.nextInt(), sc.nextInt()));
			}
		}
		out.flush();
		out.close();
	}

	static class SegmentTree {
		int a[], t[], lazy[];
		
		public SegmentTree(int[] arr, int size) {
			a = arr;
			t = new int[size * 4];
			lazy = new int[size * 4];
			Arrays.fill(lazy, -1);
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
			if(l == tl && r == tr)
				return t[v];
			push(v, tl, tr);
			int tm = (tl + tr) / 2;
			return getSum(2 * v, tl, tm, l, Math.min(tm, r)) + getSum(2 * v + 1, tm + 1, tr, Math.max(tm + 1, l), r);
		}
		
		public void update(int v, int tl, int tr, int l, int r, int type) {
			if(l > r)
				return;
			if(l == tl && r == tr) {
				if(type == 0) {
					lazy[v] = 0;
					t[v] = 0;
				}
				else if (type == 1) {
					lazy[v] = 1;
					t[v] = tr - tl + 1;
				}
				else if(type == 2) {
					t[v] = tr - tl + 1 - t[v];
					if(lazy[v] == -1)
						lazy[v] = 2;
					else if(lazy[v] == 0)
						lazy[v] = 1;
					else if(lazy[v] == 1)
						lazy[v] = 0;
					else
						lazy[v] = -1;
				}
			}
			else {
				int tm = (tl + tr) / 2;
				push(v, tl, tr);
				update(2 * v, tl, tm, l, Math.min(tm, r), type);
				update(2 * v + 1, tm + 1, tr, Math.max(tm + 1, l), r, type);
				t[v] = t[2 * v] + t[2 * v + 1];
			}
		}
		
		public void push(int v, int tl, int tr) {
			if(lazy[v] == 0 || lazy[v] == 1) {
				int tm = (tl + tr) / 2;
				lazy[2 * v] = lazy[v];
				t[2 * v] = lazy[v] == 0 ? 0 : tm - tl + 1;
				lazy[2 * v + 1] = lazy[v];
				t[2 * v + 1] = lazy[v] == 0 ? 0 : tr - tm;
				lazy[v] = -1;	
			}
			else if(lazy[v] == 2) {
				int tm = (tl + tr) / 2;
				t[2 * v] = tm - tl + 1 - t[2 * v];
				t[2 * v + 1] = tr - tm - t[2 * v + 1];
				if(lazy[2 * v] == -1)
					lazy[2 * v] = 2;
				else if(lazy[2 * v] == 0)
					lazy[2 * v] = 1;
				else if(lazy[2 * v] == 1)
					lazy[2 * v] = 0;
				else
					lazy[2 * v] = -1;
				if(lazy[2 * v + 1] == -1)
					lazy[2 * v + 1] = 2;
				else if(lazy[2 * v + 1] == 0)
					lazy[2 * v + 1] = 1;
				else if(lazy[2 * v + 1] == 1)
					lazy[2 * v + 1] = 0;
				else
					lazy[2 * v + 1] = -1;
				lazy[v] = -1;	
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