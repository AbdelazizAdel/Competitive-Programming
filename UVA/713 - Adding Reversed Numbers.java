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
		
		int n = sc.nextInt();
		while(n-->0) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			String a = st.nextToken(), b = st.nextToken();
			int limit = Math.min(a.length(), b.length());
			StringBuilder sb = new StringBuilder();
			int c = 0;
			for(int i = 0; i < limit; i++) {
				int x = Integer.parseInt(a.charAt(i) + "");
				int y = Integer.parseInt(b.charAt(i) + "");
				int sum = x + y + c;
				sb.append(sum % 10 + "");
				sum/=10;
				c = sum;
			}
			for(int i = a.length(); i < b.length(); i++) {
				int x = Integer.parseInt(b.charAt(i) + "");
				int sum = x + c;
				sb.append(sum % 10 + "");
				sum/=10;
				c = sum;
			}
			for(int i = b.length(); i < a.length(); i++) {
				int x = Integer.parseInt(a.charAt(i) + "");
				int sum = x + c;
				sb.append(sum % 10 + "");
				sum/=10;
				c = sum;
			}
			if(c != 0)
				sb.append(c);
			String ans = sb.toString();
			int start = 0;
			while(start < ans.length() && ans.charAt(start) == '0')
				start++;
			out.println(start == ans.length() ? "0" : ans.substring(start));
		}
		
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

		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}

		public boolean ready() throws IOException {return br.ready();}


	}
}