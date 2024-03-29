import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class zizo {
	static final double EPS = 1e-9;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int a = sc.nextInt(), x = sc.nextInt(), y = sc.nextInt();
		if(y % a == 0)
			System.out.println(-1);
		else {
			int lvl = (int)Math.ceil(y * 1.0 / a);
			if(lvl == 1 || lvl % 2 == 0)
				System.out.println(Math.abs(x) < a * 1.0 / 2 ? (lvl == 1 ? 1 : lvl + lvl / 2 - 1) : -1);
			else {
				if(x == 0)
					System.out.println(-1);
				else
					System.out.println((x == 0 || Math.abs(x) < a) ? (x < 0 ? lvl + lvl / 2 - 1 : lvl + lvl / 2) : -1);
			}
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

		public double nextDouble() throws IOException{return Double.parseDouble(next());}

		public boolean ready() throws IOException {return br.ready();}

	}
}