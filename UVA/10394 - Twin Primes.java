import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class zizo {
	static ArrayList<Integer> primes;
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		primes = new ArrayList<Integer>();
		seive(20000000);
		ArrayList<Pair> twin_primes = new ArrayList<Pair>();
		for(int i = 1; i < primes.size(); i++)
			if(primes.get(i) - primes.get(i - 1) == 2)
				twin_primes.add(new Pair(primes.get(i - 1), primes.get(i)));
		while(sc.ready())
			out.println(twin_primes.get(sc.nextInt() - 1));
		out.flush();
		out.close();
	}
	
	static class Pair {
		int a, b;
		
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		public String toString() {
			return "(" + a +", " + b + ")";
		}
	}
	
	public static void seive(int n) {
		boolean[] isPrime = new boolean[n + 1];
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