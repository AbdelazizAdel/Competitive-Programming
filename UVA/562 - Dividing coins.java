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
	static int memo[][], coins[], m;
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt();
		while(n-->0) {
			m = sc.nextInt();
			coins = new int[m];
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			for(int i = 0; i < m; i++)
				coins[i] = Integer.parseInt(st.nextToken());
			memo = new int[50001][m];
			for(int[] a: memo)
				Arrays.fill(a, -1);
			System.out.println(dp(0, 0, 0));
		}
		
		out.flush();
		out.close();
	}
	
	public static int dp(int r, int l, int idx) {
		if(idx == m)
			return Math.abs(r - l);
		if(memo[Math.abs(r - l)][idx] != -1)
			return memo[Math.abs(r - l)][idx];
		return memo[Math.abs(r - l)][idx] = Math.min(dp(r+coins[idx], l, idx+1), dp(r, l+coins[idx], idx+1));
		
		
		
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