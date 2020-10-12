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
		String s = sc.nextLine();
		HashSet<Character> even = new HashSet(), odd = new HashSet();
		for(int i = 0; i < s.length(); i++) {
			if(even.contains(s.charAt(i))) {
				odd.add(s.charAt(i));
				even.remove(s.charAt(i));
			}
			else if(odd.contains(s.charAt(i))) {
				even.add(s.charAt(i));
				odd.remove(s.charAt(i));
			}
			else
				odd.add(s.charAt(i));
		}
		out.println(odd.size() == 0 || odd.size() % 2 == 1 ? "First" : "Second");
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