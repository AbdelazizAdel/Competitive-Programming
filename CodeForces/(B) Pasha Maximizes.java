import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class zizo {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		char[] digits = sc.next().toCharArray();
		int k = sc.nextInt();
		for(int i = 0; i < digits.length && k > 0; i++) {
			int idx = i;
			for(int j = i + 1; j <= Math.min(digits.length - 1, i + k); j++)
				if(digits[j] > digits[idx])
					idx = j;
			k-=(idx - i);
			for(int j = idx; j > i; j--) {
				char t = digits[j];
				digits[j] = digits[j - 1];
				digits[j - 1] = t;
			}
		}
		out.println(new String(digits));
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