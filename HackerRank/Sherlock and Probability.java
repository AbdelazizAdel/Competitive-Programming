import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = sc.nextInt();
		while(T-- > 0) {
			int n = sc.nextInt(), k = sc.nextInt();
			String s = sc.nextLine();
			long count = 0l, ans = 0l;
			for(int i = 0; i < n && i < k + 1; i++) {
				if(s.charAt(i) == '1') {
					ans+=count;
					count++;
				}
			}
			for(int i = 1; i < n - k; i++) {
				if(s.charAt(i - 1) == '1')
					count--;
				if(i + k < n && s.charAt(i + k) == '1') {
					ans+=count;
					count++;
				}
			}
			ans*=2;
			for(int i = 0; i < n; i++)
				if(s.charAt(i) == '1')
					ans++;
			long total = (long) n * (long) n, gcd = gcd(ans, total);
			out.printf("%d/%d", ans / gcd, total / gcd);
		}
		out.flush();
		out.close();
	}
	
	public static long gcd(long a, long b) {
		if(a == 0)
			return b;
		return gcd(b % a, a);
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