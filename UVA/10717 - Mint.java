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

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		while (true) {
			int n = sc.nextInt(), t = sc.nextInt();
			if (n == 0 && t == 0)
				break;
			int[] coins = new int[n], heights = new int[t];
			for (int i = 0; i < n; i++)
				coins[i] = sc.nextInt();
			for (int i = 0; i < t; i++)
				heights[i] = sc.nextInt();
			for (int i = 0; i < t; i++) {
				long max = 0l, min = Long.MAX_VALUE;
				for (int a = 0; a < n - 3; a++)
					for (int b = a + 1; b < n - 2; b++)
						for (int c = b + 1; c < n - 1; c++)
							for (int d = c + 1; d < n; d++) {
								long lcm = lcm(lcm(lcm(coins[a], coins[b]), coins[c]), coins[d]);
								long x = heights[i] / lcm, y = x * lcm == heights[i] ? x : x + 1;
								max = Math.max(max, x * lcm);
								min = Math.min(min, y * lcm);
							}
				out.printf("%d %d%n", max, min);
			}
		}
		out.flush();
		out.close();
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