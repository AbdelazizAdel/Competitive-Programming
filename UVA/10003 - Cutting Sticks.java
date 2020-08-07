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
	static int memo[][], cuts[];
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while(true) {
			int l = sc.nextInt();
			if(l == 0)
				break;
			int n = sc.nextInt();
			String[] in = sc.nextLine().split(" ");
			cuts = new int[n];
			for(int i = 0; i < n; i++)
				cuts[i] = Integer.parseInt(in[i]);
			memo = new int[l+1][l+1];
			for(int[] a: memo)
				Arrays.fill(a, -1);
			int ans = dp(0, l, 0, n-1);
			out.println("The minimum cutting is "+ ans+ ".");
		}
		
		out.flush();
		out.close();
	}
	
	public static int dp(int b, int e, int s, int f) {
		if(s > f)
			return 0;
		if(memo[b][e] != -1)
			return memo[b][e];
		int min = (int)1e9;
		for(int i = s; i <= f; i++) {
			int cost = e - b;
			int right = dp(b, cuts[i], s, i-1);
			int left = dp(cuts[i], e, i+1, f);
			min = Math.min(min, cost + right + left);
		}
		return memo[b][e] = min;
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