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
		int a = sc.nextInt(), b = sc.nextInt();
		long lcm = lcm(a, b);
		ArrayList<Moment> moments = new ArrayList();
		long idx = 1l;
		while(a * idx < lcm) {
			moments.add(new Moment(a * idx, true));
			idx++;
		}
		idx = 1l;
		while(b * idx <= lcm) {
			moments.add(new Moment(b * idx, b * idx == lcm ? b < a : false));
			idx++;
		}
		Collections.sort(moments);
		long dasha = 0l, masha = 0l;
		for(int i = 0; i < moments.size(); i++) {
			if(moments.get(i).first)
				dasha = dasha + moments.get(i).t - (i > 0 ? moments.get(i - 1).t : 0);
			else
				masha = masha + moments.get(i).t - (i > 0 ? moments.get(i - 1).t : 0);
		}
		out.println(masha > dasha ? "Masha" : (dasha > masha ? "Dasha" : "Equal"));
		out.flush();
		out.close();
	}
	
	static class Moment implements Comparable<Moment>{
		long t;
		boolean first;
		
		public Moment(long a, boolean b) {
			t = a;
			first = b;
		}
		
		public int compareTo(Moment p) {
			if(t > p.t)
				return 1;
			if(t < p.t)
				return -1;
			return 0;
		}
		
		public String toString() {
			return t + " " + first;
		}
	}
	
	public static long gcd(long a, long b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	public static long lcm(long a, long b) {
		return a * b / gcd(a, b);
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