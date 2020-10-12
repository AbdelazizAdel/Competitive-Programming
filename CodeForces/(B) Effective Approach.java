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
		HashMap<Integer, Integer> first = new HashMap();
		HashMap<Integer, Integer> last = new HashMap();
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			int e = sc.nextInt();
			if(!first.containsKey(e))
				first.put(e, i + 1);
			last.put(e, n - i);
		}
		int m = sc.nextInt();
		long vasya = 0, petya = 0;
		for(int i = 0; i < m; i++) {
			int q = sc.nextInt();
			vasya+=first.get(q);
			petya+=last.get(q);
		}
		System.out.println(vasya + " " + petya);
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