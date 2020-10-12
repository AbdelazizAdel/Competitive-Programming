import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class zizo {
	static long[] powers;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		while(sc.ready()) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			int[] coeff = new int[st.countTokens()];
			for(int i = 0; i < coeff.length; i++)
				coeff[i] = Integer.parseInt(st.nextToken());
			powers = new long[coeff.length];
			st = new StringTokenizer(sc.nextLine());
			while(st.hasMoreTokens()) {
				long ans = 0l, b = Long.parseLong(st.nextToken());
				pow(b, coeff.length - 1);
				for(int i = 0; i < coeff.length; i++) 
					ans = ans + coeff[i] * powers[coeff.length - i - 1];
				out.print(ans + (st.hasMoreTokens() ? " " : "\n"));
			}
		}
		out.flush();
		out.close();
	}
	
	public static long pow(long b, int p) {
		if(p == 0)
			return powers[p] = 1;
		return powers[p] = b * pow(b, p - 1); 
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