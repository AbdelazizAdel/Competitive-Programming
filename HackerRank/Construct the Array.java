import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class zizo{
	static int n, k, x;
	static long memo[][];
	static final int mod = (int)1e9+7;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		n = sc.nextInt();
		k = sc.nextInt();
		x = sc.nextInt();
		memo = new long[n][2];
		memo[0][0] = 1;
		for(int i = 1; i < n; i++) {
			memo[i][0] = (memo[i-1][1]%mod * (k-1))%mod;
			memo[i][1] = (memo[i-1][0]%mod + (memo[i-1][1]%mod * (k-2))%mod)%mod;
		}
		System.out.println(x==1?memo[n-1][0]:memo[n-1][1]);
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