import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class zizo7 {
	static int memo[][], nums[], N, K;
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int M = sc.nextInt();
		while(M-->0) {
			N = sc.nextInt();
			K = sc.nextInt();
			memo = new int[N][K];
			for(int[] a: memo)	
				Arrays.fill(a, -1);
			nums = new int[N];
			for(int i = 0; i < N; i++)
				nums[i] = sc.nextInt();
			String ans = dp(1, (nums[0]%K+K)%K)==0?"Divisible":"Not divisible";
			out.println(ans);
		}
		
		out.flush();
		out.close();
	}
	
	public static int dp(int idx, int rem) {
		if(idx == N)
			return rem;
		if(memo[idx][rem] != -1)
			return memo[idx][rem];
		return memo[idx][rem] = Math.min(dp(idx+1, mod(rem+nums[idx])), dp(idx+1, mod(rem-nums[idx])));
		
			
	}
	public static int mod(int x) {
		return (x%K+K)%K;
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