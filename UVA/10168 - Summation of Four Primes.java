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
		primes = new ArrayList();
		seive((int)1e7);
		while(sc.ready()) {
			int n = sc.nextInt();
			if(n < 8)
				out.println("Impossible.");
			else {
				int a = 0, b = 0, d = n % 2 == 0 ? 4 : 5;
				for(int i = 0; primes.get(i) <= (n - d) / 2; i++) {
					if(isPrime[primes.get(i)] && isPrime[n - d - primes.get(i)]) {
						a = primes.get(i);
						b = n - d - primes.get(i);
						break;
					}
				}
				if(n % 2 == 0)
					out.println("2 2 " + a + " " + b);
				else
					out.println("2 3 " + a + " " + b);
			}
		}
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