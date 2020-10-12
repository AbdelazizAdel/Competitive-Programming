import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class zizo {
	static final long MOD = (long)1e9 + 7l;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt();
		long ans = (pow(3, 3 * n) - pow(7, n) + MOD) % MOD ;
		out.println(ans);
		out.flush();
		out.close();
	}
	
	public static long pow(int b, int p) {
		if(p == 0)
			return 1;
		long temp = pow(b, p / 2);
		long ans = ((temp % MOD) * (temp % MOD)) % MOD;
		if((p & 1) == 1)
			ans = (ans * b) % MOD;
		return ans;
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