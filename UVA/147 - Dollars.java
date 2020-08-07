import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class zizo{
	static final int[] coins = {5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000};
	static final int n = 11;
	static long memo[][];
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		while(true) {
			String x = sc.nextLine();
			if(x.equals("0.00"))
				break;
			int amount = Integer.parseInt(x.replace(".", "")) + 1;
			memo = new long[n][amount];
			for(long[] a: memo)
				Arrays.fill(a, -1);
			long ans = dp(0, amount-1);

			out.printf("%6s%17s%n", x, ans);
		}
		
		out.flush();
		out.close();
	}
	
	public static long dp(int idx, int rem) {
		if(rem == 0)
			return 1;
		if(idx == n)
			return 0;
		if(memo[idx][rem] != -1)
			return memo[idx][rem];
		long leave = dp(idx+1, rem);
		long take = 0;
		if(rem - coins[idx] >= 0)
			take = dp(idx, rem-coins[idx]);
		return memo[idx][rem] = leave + take;
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