import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt(), f = sc.nextInt();
		Pair[] pairs = new Pair[n];
		for(int i = 0; i < n; i++)
			pairs[i] = new Pair(sc.nextInt(), sc.nextInt());
		Arrays.sort(pairs);
		long ans = 0;
		for(int i = 0; i < n; i++) {
			if(i < f)
				ans+=Math.min(2 * pairs[i].k, pairs[i].l);
			else
				ans+=Math.min(pairs[i].k, pairs[i].l);
		}
		out.println(ans);
		out.flush();
		out.close();
	}
	
	static class Pair implements Comparable<Pair> {
		int k, l;
		
		public Pair(int a, int b) {
			k = a;
			l = b;
		}
		
		public int compareTo(Pair p) {
			int a = 2 * k > l ? l - k : k;
			int b = 2 * p.k > p.l ? p.l - p.k : p.k;
			return b - a;
		}
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