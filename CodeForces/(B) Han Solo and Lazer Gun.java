import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.*;

public class zizo {
	static final long pow = 31, pow_3 = (int) Math.pow(pow, 3);
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt(), x0 = sc.nextInt(), y0 = sc.nextInt();
		TreeSet<BigDecimal> set = new TreeSet();
		boolean vertical = false;
		for(int i = 0; i < n; i++) {
			double slope = (sc.nextInt() - x0) * 1.0 / (sc.nextInt() - y0);
			if(Double.isInfinite(slope))
				vertical = true;
			else {
				BigDecimal x = new BigDecimal(String.format("%.9f", slope));
				set.add(x);
			}
		}
		out.println(set.size() + (vertical ? 1 : 0));
		out.flush();
		out.close();
	}

	static class Slope {
		double s;

		public Slope(double a) {
			s = a;
		}

		public boolean equals(Slope b) {
			return Math.abs(s - b.s) < 1e-6;
		}
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