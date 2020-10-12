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
		int n = sc.nextInt(), k = sc.nextInt();
		if((n % 2 == 0 && k > n * (n / 2))|| (n % 2 == 1 && k > (n / 2 + 1) * (n / 2 + 1) + (n / 2) * (n / 2)))
			out.println("NO");
		else {
			int count = 0, start = 0;
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(j % 2 == start && count < k) {
						count++;
						sb.append('L');
					}
					else
						sb.append('S');
				}
				start = 1 - start;
				sb.append("\n");
			}
			out.print("YES\n" + sb.toString());
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