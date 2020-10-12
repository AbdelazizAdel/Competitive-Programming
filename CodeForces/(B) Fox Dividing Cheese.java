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
		int a = sc.nextInt(), b = sc.nextInt();
		primes = new ArrayList<Integer>();
		seive((int)1e5);
		TreeMap<Integer, Integer> map_a = new TreeMap(), map_b = new TreeMap();
		primeFactors(a, map_a);
		primeFactors(b, map_b);
		int ans = 0;
		ans = ans + Math.abs(map_a.getOrDefault(2, 0) - map_b.getOrDefault(2, 0)) + Math.abs(map_a.getOrDefault(3, 0) - map_b.getOrDefault(3, 0)) + Math.abs(map_a.getOrDefault(5, 0) - map_b.getOrDefault(5, 0));
		map_a.remove(2);map_a.remove(3);map_a.remove(5);map_b.remove(2);map_b.remove(3);map_b.remove(5);
		boolean flag = true;
		while(map_a.size() > 0 && map_b.size() > 0) {
			if(!map_a.pollFirstEntry().equals(map_b.pollFirstEntry())) {
				flag = false;
				break;
			}
		}
		if(!flag || map_a.size() > 0 || map_b.size() > 0)
			out.println(-1);
		else
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
	
	public static void primeFactors(int x, TreeMap<Integer, Integer> map) {
		int idx = 0;
		while(idx < primes.size() && primes.get(idx) * primes.get(idx) <= x) {
			if(x % primes.get(idx) == 0) {
				map.put(primes.get(idx), map.getOrDefault(primes.get(idx), 0) + 1);
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