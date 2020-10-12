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
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		long n = sc.nextLong();
		primes = new ArrayList();
		seive((int)1e6);
		TreeMap<Long, Integer> map = new TreeMap();
		primeFactors(n, map);
		long ans = 1l;
		while(map.size() > 0)
			ans*=map.pollFirstEntry().getKey();
		out.println(ans);
		out.flush();
		out.close();
	}
	
	public static void seive(int n) {
		isPrime = new boolean[n + 1];
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		for(int i = 2; i * i <= n; i++)
			if(isPrime[i])
				for(int j = i; i * j <= n; j++)
					isPrime[i * j] = false;
		for(int i = 0; i <= n; i++)
			if(isPrime[i])
				primes.add(i);
	}
	
	public static void primeFactors(long x, TreeMap<Long, Integer> map) {
		int idx = 0;
		while(idx < primes.size() && primes.get(idx) * primes.get(idx) <= x) {
			if(x % primes.get(idx) == 0) {
				map.put((long)primes.get(idx), map.getOrDefault((long)primes.get(idx), 0) + 1);
				x/=primes.get(idx);
			}
			else
				idx++;
		}
		if(x > 1)
			map.put(x, map.getOrDefault(x, 0) + 1);
	}
	
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}

		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}

		public double nextDouble() throws IOException{return Double.parseDouble(next());}

		public boolean ready() throws IOException {return br.ready();}

	}
}