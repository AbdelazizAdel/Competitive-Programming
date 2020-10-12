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
	static final long MOD = 2000000011l;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt(), m = sc.nextInt(), t = sc.nextInt();
		long ans = 0l;
		for(int i = 1; i <= t - 4; i++) {
			if(t - i > n || i > m)
				continue;
			ans+=(combination(n, t - i) * combination(m, i));
		}
		out.println(ans);
		out.flush();
		out.close();
	}
	
	public static long combination(int n, int r) {
		long ans = 1l;
		if(r > n - r)
			r = n - r;
		for(long i = 1l; i <= r; i++)
			ans = ans * (n - r + i) / i;
		return ans;
	}
	
	public static long factorial(int n) {
		if(n == 0)
			return 1l;
		return n * factorial(n - 1);
	}
	
	static class Triple {
		int a, b, c;
		
		public Triple(int x, int y, int z) {
			a = x;
			b = y;
			c= z;
		}
		public String toString() {
			return a + " " + b + " " + c;
		}
	}
	
	public static long pow(long b, long p) {
		if(p == 0)
			return 1l;
		long t = pow(b, p / 2) % MOD;
		long ans = (t * t) % MOD;
		if(p % 2 == 1)
			ans = (ans * b) % MOD;
		return ans;
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