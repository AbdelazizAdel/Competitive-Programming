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
		while(true) {
			String s = sc.nextLine().trim();
			StringTokenizer st = new StringTokenizer(s, " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if(N == 0 && M == 0)
				break;
			ArrayList<Integer> primes = new ArrayList();
			findPrimes(primes);
			int[] numerator = new int[primes.size()], denomenator = new int[primes.size()];
			if(N - M >= M) {
				for(int i = N; i > N - M; i--)
					primeFactors(i, numerator, primes);
				for(int i = M; i > 1; i--)
					primeFactors(i, denomenator, primes);
			}
			else {
				for(int i = N; i > M; i--)
					primeFactors(i, numerator, primes);
				for(int i = N - M; i > 1; i--)
					primeFactors(i, denomenator, primes);
			}
			int a = 1, b = 1;
			for(int i = 0; i < numerator.length; i++) {
				if(numerator[i] == denomenator[i])
					continue;
				if(numerator[i] > denomenator[i])
					a*=(int) Math.pow(primes.get(i), numerator[i] - denomenator[i]);
				else
					b*=(int) Math.pow(primes.get(i), denomenator[i] - numerator[i]);
			}
			out.printf("%d things taken %d at a time is %d exactly.%n", N, M, a / b);
		}
		out.flush();
		out.close();
	}

	public static void findPrimes(ArrayList<Integer> list) {
		boolean[] isComposite = new boolean[101];
		isComposite[0] = isComposite[1] = true;
		int len = (int) Math.floor(Math.sqrt(100));
		for(int i = 2; i <= len; i++) {
			if(isComposite[i])
				continue;
			for(int j = i; j * i <= 100; j++)
				isComposite[j * i] = true;
		}
		for(int i = 0; i < 101; i++)
			if(!isComposite[i])
				list.add(i);
	}

	public static void primeFactors(int num, int[] arr, ArrayList<Integer> primes) {
		int len = (int) Math.floor(Math.sqrt(num)), idx = 0;
		while(num > 1 && primes.get(idx) <= len) {
			if(num % primes.get(idx) == 0) {
				num/=primes.get(idx);
				len = (int) Math.floor(Math.sqrt(num));
				arr[idx]++;
			}
			else
				idx++;
		}
		if(num > 1)
			arr[Collections.binarySearch(primes, num)]++;
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