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
		int n = sc.nextInt(), k = sc.nextInt(), l = sc.nextInt(), r = sc.nextInt(), s_all = sc.nextInt(), s_k = sc.nextInt();
		int[] ans = new int[n];
		Arrays.fill(ans, l);
		int a = (s_k - k * l) / k, b = (s_k - k * l) % k;
		int c = n == k ? 0 : (s_all - s_k - (n - k) * l) / (n - k), d = n == k ? 0 : (s_all - s_k - (n - k) * l) % (n - k);
		for(int i = 0; i < n; i++) {
			if(i < k)
				ans[i]+=a;
			if(i < b)
				ans[i]++;
			if(i >= k)
				ans[i]+=c;
			if(i - k >= 0 && i - k < d)
				ans[i]++;
		}
		for(int i = 0; i < n; i++)
			out.print(ans[i] + (i == n - 1 ? "\n" : " "));
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