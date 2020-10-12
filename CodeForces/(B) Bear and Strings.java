import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class zizo {
	static final long pow = 31, pow_3 = (int) Math.pow(pow, 3);
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		String s = sc.nextLine();
		if(s.length() < 4) {
			System.out.println(0);
			return;
		}
		long[] hashCodes = new long[s.length() - 3];
		String x = "bear";
		long p = 1, c = 0;
		for(int i = 3; i >= 0; i--) {
			c = c + x.charAt(i) * p;
			hashCodes[0] = hashCodes[0] + s.charAt(i) * p;
			p*=pow;
		}
		for(int i = 1; i < hashCodes.length; i++)
			hashCodes[i] = (hashCodes[i - 1] - s.charAt(i - 1) * pow_3) * pow + s.charAt(i + 3);
		long ans = 0, prev = -1;
		for(int i = 0; i < hashCodes.length; i++) {
			if(hashCodes[i] == c && s.substring(i, i + 4).equals(x)) {
				ans = ans + (i - prev) * (s.length() - i - 3);
				prev = i;
			}
		}
		out.println(ans);
		out.flush();
		out.close();
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