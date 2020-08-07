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
	static int memo[][];
	static String m, f;
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int i = 1;
		while(true) {
			m = sc.nextLine();
			if(m.equals("#"))
				break;
			f = sc.nextLine();
			memo = new int[m.length()][f.length()];
			for(int[] a: memo)
				Arrays.fill(a, -1);
			out.printf("Case #%d: you can visit at most %d cities.\n", i++, dp(0, 0));
		}
		
		out.flush();
		out.close();
	}
	
	public static int dp(int idx1, int idx2) {
		if(idx1 == m.length() || idx2 == f.length())
			return 0;
		if(memo[idx1][idx2] != -1)
			return memo[idx1][idx2];
		if(m.charAt(idx1) == f.charAt(idx2))
			return memo[idx1][idx2] = 1 + dp(idx1 + 1, idx2 + 1);
		return memo[idx1][idx2] = Math.max(dp(idx1, idx2 + 1), dp(idx1 + 1, idx2));
		
		
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