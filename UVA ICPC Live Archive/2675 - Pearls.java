import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class zizo{
	static int n, q[], p[], sum[], memo[][];
	static final int INF = (int) 1e9;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		while(t-->0) {
			n = sc.nextInt();
			q = new int[n];
			p = new int[n];
			for(int i = 0; i < n; i++) {
				q[i] = sc.nextInt();
				p[i] = sc.nextInt();
			}
			sum = new int[n];
			sum[0] = q[0];
			for(int i = 1; i < n; i++)
				sum[i] = sum[i-1] + q[i];
			memo = new int[n][n];
			for(int[] a: memo)
				Arrays.fill(a, -1);
			out.println(dp(0, 0));
		}
		
		out.flush();
		out.close();
	}
	
	public static int dp(int b, int e) {
		if(e == n) {
			if(b != n)
				return INF;
			return 0;
		}
		if(memo[b][e] != -1)
			return memo[b][e];
		int val = ((b==e?q[b]:sum[e]-sum[b]+q[b]) + 10) * p[e];
		return memo[b][e] = Math.min(val+dp(e+1, e+1), dp(b, e+1));
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