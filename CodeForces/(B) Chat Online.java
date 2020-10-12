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
		int p = sc.nextInt(), q = sc.nextInt(), l = sc.nextInt(), r = sc.nextInt();
		Pair[] X = new Pair[p], Z = new Pair[q];
		for(int i = 0; i < p; i++)
			X[i] = new Pair(sc.nextInt(), sc.nextInt());
		for(int i = 0; i < q; i++)
			Z[i] = new Pair(sc.nextInt(), sc.nextInt());
		int cnt = 0;
		for(int i = l; i <= r; i++) {
			outer:for(int j = 0; j < q; j++) {
				for(int k = 0; k < p; k++) {
					if(!(Z[j].b + i < X[k].a || Z[j].a + i > X[k].b)) {
						cnt++;
						break outer;
					}
				}
			}
		}
		out.println(cnt);
		out.flush();
		out.close();
	}
	
	static class Pair {
		int a, b;
		
		public Pair(int x, int y) {
			a = x;
			b = y;
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