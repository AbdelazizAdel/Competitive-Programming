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
	static int events[], n;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		n = sc.nextInt();
		while(sc.ready()) {
			int[] t1 = new int[n];
			for(int i = 0; i < n; i++)
				t1[i] = sc.nextInt();
			events = new int[n];
			for(int i = 0; i < n; i++)
				events[t1[i]-1] = i+1;
			while(true) {
				StringTokenizer st = new StringTokenizer(sc.nextLine());
				if(st.countTokens() == 1) {
					n = Integer.parseInt(st.nextToken());
					break;
				}
				int[] t2 = new int[n];
				for(int i = 0; i < n; i++)
					t2[i] = Integer.parseInt(st.nextToken());
				int[] answers = new int[n];
				for(int i = 0; i < n; i++)
					answers[t2[i]-1] = i+1;
				int[] dp = new int[n];
				Arrays.fill(dp, 1);
				for(int i = 1; i < n; i++) {
					for(int j = 0; j < i; j++) {
						if(lessThan(answers[j], answers[i]))
							dp[i] = Math.max(dp[i], 1 + dp[j]);
					}
				}
				int ans = 0;
				for(int i = 0; i < n; i++)
					ans = Math.max(ans, dp[i]);
				out.println(ans);
				if(!sc.ready())
					break;
			}	
		}
		
		out.flush();
		out.close();
 	}

	public static boolean lessThan(int a, int b) {
		for(int i = 0; i < n; i++) {
			if(events[i] == a)
				return true;
			if(events[i] == b)
				return false;
		}
		return true;		
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