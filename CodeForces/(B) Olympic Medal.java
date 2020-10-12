import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class zizo {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt(), r1  = 0;
		for(int i = 0; i < n; i++)
			r1 = Math.max(r1, sc.nextInt());
		int m = sc.nextInt();
		int[] arr = new int[m];
		for(int i = 0; i < m; i++)
			arr[i] = sc.nextInt();
		int k = sc.nextInt(), p2 = Integer.MAX_VALUE;
		for(int i = 0; i < k; i++)
			p2 = Math.min(p2, sc.nextInt());
		int A = sc.nextInt(), B = sc.nextInt();
		double ans = 0;
		for(int i = 0; i < m; i++) {
			double x = arr[i] * 1.0 * B * r1 * r1;
			double y = arr[i] * 1.0 * B + p2 * 1.0 * A;
			ans = Math.max(ans, Math.sqrt(x / y));
		}
		out.printf("%.12f", ans);
		out.flush();
		out.close();
	}
	
	static class Pair {
		int a, b;
		
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
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