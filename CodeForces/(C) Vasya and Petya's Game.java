import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class Solution {
	static ArrayList<Integer> primes;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt();
		sieve_of_eratosthenes(n);
		ArrayList<Integer> questions = new ArrayList<Integer>();
		for(int p : primes) {
			int pow = p;
			while(pow <= n) {
				questions.add(pow);
				pow*=p;
			}
		}
		System.out.println(questions.size());
		for(int i = 0; i < questions.size(); i++) {
			out.print(questions.get(i) + (i == questions.size() - 1 ? "\n" : " "));
		}
		out.flush();
		out.close();
	}

	
	public static ArrayList<Integer> sieve_of_eratosthenes(int n) {
		primes = new ArrayList<Integer>();
		boolean[] isComposite = new boolean[n + 1];
		isComposite[0] = isComposite[1] = true;
		int limit = (int) Math.sqrt(n);
		for(int i = 2; i <= limit; i++) {
			if(isComposite[i])
				continue;
			for(int j = i; i * j <= n; j++)
				isComposite[i * j] = true;
		}
		for(int i = 0; i < n + 1; i++)
			if(!isComposite[i])
				primes.add(i);
		return primes;
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