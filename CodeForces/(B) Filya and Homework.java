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
		TreeSet<Integer> set = new TreeSet();
		while(n-- > 0)
			set.add(sc.nextInt());
		if(set.size() > 3)
			out.println("NO");
		else if(set.size() < 3)
			out.println("YES");
		else {
			int a = set.pollFirst(), b = set.pollFirst(), c = set.pollFirst();
			if(b - a == c - b)
				out.println("YES");
			else
				out.println("NO");
		}
		out.flush();
		out.close();
	}
	
	static class Pair {
		int a, b;
		
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
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