import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class zizo {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt(), num = 0;
		String ugly = "1";
		boolean zero = false;
		for(int i = 0; i < n; i++) {
			String s = sc.next();
			if(check(s))
				num+=s.length() - 1;
			else
				ugly = s;
			if(s.equals("0"))
				zero = true;
		}
		StringBuilder sb = new StringBuilder(ugly);
		for(int i = 0; i < num; i++)
			sb.append("0");
		out.println(zero ? "0" : sb.toString());
		out.flush();
		out.close();
	}
	
	public static boolean check(String s) {
		int cnt = 0;
		for(int i = 0; i < s.length(); i++)
			if(s.charAt(i) != '0' && s.charAt(i) != '1')
				return false;
			else if(s.charAt(i) == '1')
				cnt++;
		return cnt == 1;
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