import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.math.*;

public class Main{
	static HashMap<Integer, Long> memo;
	public static void main (String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		while(sc.ready()) {
			memo = new HashMap();
			memo.put(0, 0l);
			int n = sc.nextInt();
			System.out.println(solve(n));
		}
		
		out.flush();
		out.close();
	}
	
	public static long solve(int x) {
		if(x == 0) {
			return 0;
		}
		
		if(memo.containsKey(x))
			return memo.get(x);
		
		long tmp = Math.max(x, solve(x/2) + solve(x/3) + solve(x/4));
		memo.put(x,  tmp);
		return tmp;
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