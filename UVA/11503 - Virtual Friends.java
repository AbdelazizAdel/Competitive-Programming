import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = sc.nextInt();
		while(T-- > 0) {
			int F = sc.nextInt();
			Pair[] arr = new Pair[F];
			HashMap<String, Integer> map = new HashMap();
			int idx = 0, num = 0;
			while(F-- > 0) {
				String x = sc.next(), y = sc.next();
				arr[idx++] = new Pair(x, y);
				if(!map.containsKey(x))
					map.put(x, num++);
				if(!map.containsKey(y))
					map.put(y, num++);
			}
			UnionFind uf = new UnionFind(num);
			for(int i = 0; i < arr.length; i++) {
				uf.union(map.get(arr[i].x), map.get(arr[i].y));
				out.println(uf.getSize(map.get(arr[i].x)));
			}
		}
		out.flush();
		out.close();
	}
	
	static class Pair {
		String x, y;
		
		public Pair(String a, String b) {
			x = a;
			y = b;
		}
	}
	
	static class UnionFind {
		int p[], rank[], sz[], size;

		public UnionFind(int N) {
			size = N;
			p = new int[N];
			rank = new int[N];
			sz = new int[N];
			for (int i = 0; i < N; i++) {
				p[i] = i;
				sz[i] = 1;
			}
		}

		public int findSet(int x) {
			return x == p[x] ? x : (p[x] = findSet(p[x]));
		}

		public boolean union(int x, int y) {
			int p1 = findSet(x), p2 = findSet(y);
			if (p1 == p2)
				return false;
			if (rank[p1] >= rank[p2]) {
				p[p2] = p1;
				sz[p1]+=sz[p2];
				if (rank[p1] == rank[p2])
					rank[p1]++;
			} else {
				p[p1] = p2;
				sz[p2]+=sz[p1];
			}
			size--;
			return true;
		}
		
		public int getSize(int x) {
			return sz[findSet(x)];
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