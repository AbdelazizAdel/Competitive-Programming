import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class zizo{
	static BigInteger memo[];
	static BigInteger t1, t2;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		t1 = new BigInteger(sc.nextInt()+"");
		t2 = new BigInteger(sc.nextInt()+"");
		int n = sc.nextInt();
		memo = new BigInteger[n];
		System.out.println(dp(n-1));

	}

	public static BigInteger dp(int x) {
		if(x == 0)
			return t1;
		if(x == 1)
			return t2;
		if(memo[x] != null)
			return memo[x];
		return memo[x] = dp(x-2).add(dp(x-1).pow(2));
		
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