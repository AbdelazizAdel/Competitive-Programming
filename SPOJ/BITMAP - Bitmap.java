import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class zizo {
	static ArrayList<Integer> primes;
	static boolean[] isPrime;
	static int bitmap[][], ans[][], n, m;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = sc.nextInt();
		while (T-- > 0) {
			n = sc.nextInt();
			m = sc.nextInt();
			bitmap = new int[n][m];
			ans = new int[n][m];
			for (int[] arr : ans)
				Arrays.fill(arr, 5000);
			for (int i = 0; i < n; i++) {
				String row = sc.nextLine();
				for (int j = 0; j < m; j++)
					bitmap[i][j] = Integer.parseInt(row.charAt(j) + "");
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					Queue<Pair> q = new LinkedList();
					if (bitmap[i][j] == 0)
						continue;
					q.add(new Pair(i, j));
					ans[i][j] = 0;
					while(!q.isEmpty()) {
						Pair p = q.poll();
						for(int idx = 0; idx < 4; idx++) {
							int x = p.a + dx[idx], y = p.b + dy[idx];
							if(valid(x, y) && ans[x][y] > ans[p.a][p.b] + 1) {
								q.add(new Pair(x, y));
								ans[x][y] = ans[p.a][p.b] + 1;
							}
						}
					}
				}
			}
			for(int i = 0; i < n; i++)
				for(int j = 0; j < m; j++)
					out.print(ans[i][j] + (j == m - 1 ? "\n" : " "));
			if(sc.ready())
				out.println();
		}
		out.flush();
		out.close();
	}

	static class Pair {
		int a, b;

		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	public static boolean valid(int i, int j) {
		return i >= 0 && i < n && j >= 0 && j < m;
	}

	public static long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}

	public static long gcd(long a, long b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	public static void seive(int n) {
		isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i * i <= n; i++)
			if (isPrime[i])
				for (int j = i; i * j <= n; j++)
					isPrime[i * j] = false;
		for (int i = 0; i <= n; i++)
			if (isPrime[i])
				primes.add(i);
	}

	public static void primeFactors(long x, TreeMap<Long, Integer> map) {
		int idx = 0;
		while (idx < primes.size() && primes.get(idx) * primes.get(idx) <= x) {
			if (x % primes.get(idx) == 0) {
				map.put((long) primes.get(idx), map.getOrDefault((long) primes.get(idx), 0) + 1);
				x /= primes.get(idx);
			} else
				idx++;
		}
		if (x > 1)
			map.put(x, map.getOrDefault(x, 0) + 1);
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