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
	static ArrayList<Integer> arr = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder sb = new StringBuilder();
		
		int t = 0;
		while(true) {
			while((n = sc.nextInt()) != -1)
				arr.add(n);
			int[] dp = new int[arr.size()];
			Arrays.fill(dp, 1);
			for(int i = 1; i < arr.size(); i++)
				for(int j = 0; j < i; j++)
					if(arr.get(j) >= arr.get(i))
						dp[i] = Math.max(dp[i], dp[j]+1);
			int ans = 0;
			for(int i = 0; i < arr.size(); i++)
				ans = Math.max(ans, dp[i]);
			sb.append("Test #"+(++t)+":\n");
			sb.append("  maximum possible interceptions: "+ans+"\n");
			n = sc.nextInt();
			if(n == -1)
				break;
			sb.append("\n");
			arr = new ArrayList<Integer>();
			arr.add(n);
			
		}
		System.out.print(sb);
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