import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class zizo2{
	
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		while(true) {
			int n = sc.nextInt();
			if(n == 0)
				break;
			int[] arr = new int[n];
			for(int i = 0; i < n; i++)
				arr[i] = sc.nextInt();
			int ans = 0, sum = 0;
			for(int i = 0; i < n; i++) {
				sum+=arr[i];
				ans = Math.max(ans, sum);
				sum = sum<0?0:sum;
			}
			if(ans == 0)
				out.printf("Losing streak.%n");
			else
				out.printf("The maximum winning streak is %d.%n", ans);
		}
		
		out.flush();
		out.close();
 	}


	static class Scanner {
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