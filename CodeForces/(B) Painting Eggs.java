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
		int n = sc.nextInt();
		int A = 0, G = 0;
		StringBuilder ans = new StringBuilder();
		while(n-- > 0) {
			int a = sc.nextInt(), g = sc.nextInt();
			if(Math.abs(A + a - G) <= Math.abs(G + g - A)) {
				A+=a;
				ans.append("A");
			}
			else {
				G+=g;
				ans.append("G");
			}
		}
		if(Math.abs(A - G) <= 500)
			out.println(ans);
		else
			out.println(-1);
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