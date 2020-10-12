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
		String s1 = sc.nextLine(), s2 = sc.nextLine();
		int pos_1 = 0, neg_1 = 0, pos_2 = 0, neg_2 = 0, unrec = 0;
		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) == '+')
				pos_1++;
			else
				neg_1++;
		}
		for(int i = 0; i < s2.length(); i++) {
			if(s2.charAt(i) == '+')
				pos_2++;
			if(s2.charAt(i) == '-')
				neg_2++;
			if(s2.charAt(i) == '?')
				unrec++;
		}
		double ans = 0;
		if(pos_2 > pos_1 || neg_2 > neg_1)
			ans = 0;
		else {
			int num = pos_1 - pos_2;
			double a = factorial(unrec);
			double b = factorial(unrec - num) * factorial(num) * (1 << unrec);
			ans = a / b;
		}
		out.printf("%.12f", ans);
		out.flush();
		out.close();
	}
	
	public static double factorial(int n) {
		if(n == 0)
			return 1;
		return n * factorial(n - 1);
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