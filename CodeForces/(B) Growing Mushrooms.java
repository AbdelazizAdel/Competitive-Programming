import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class zizo {
	static final double EPS = 1e-9;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt(), t1 = sc.nextInt(), t2 = sc.nextInt(), k = sc.nextInt();
		Pair[] pairs = new Pair[n];
		double p = (100 - k) / 100.0;
		for(int i = 0; i < n; i++) {
			int u = sc.nextInt(), v = sc.nextInt();
			double val = Math.max(u * t1 * p + v * t2, v * t1 * p + u * t2);
			pairs[i] = new Pair(val, i + 1);
		}
		Arrays.sort(pairs);
		for(Pair pair : pairs)
			out.println(pair);
		out.flush();
		out.close();
	}
	
	static class Pair implements Comparable<Pair>{
		double val;
		int idx;
		
		public Pair(double x, int y) {
			val = x;
			idx = y;
		}
		
		public int compareTo(Pair p) {
			if(Math.abs(p.val - val) < EPS)
				return idx - p.idx;
			return p.val > val ? 1 : -1;
		}
		public String toString() {
			return idx + " " + String.format("%.2f", val);
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