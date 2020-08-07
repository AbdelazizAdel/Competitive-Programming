import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class zizo2{
	static ArrayList<Elephant> arr;
	static int memo[][], n;
	static PrintWriter out = new PrintWriter(System.out);
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		out = new PrintWriter(System.out);
		Thread.sleep(3000);
		arr = new ArrayList<Elephant>();
		arr.add(new Elephant(0, 10001, 0));
		int t = 0;
		while(sc.ready())
			arr.add(new Elephant(sc.nextInt(), sc.nextInt(), ++t));
		Collections.sort(arr);
		n = arr.size();
		memo = new int[n][n];
		for(int[] a: memo)
				Arrays.fill(a, -1);
		out.println(dp(0, 1));
		printSol(0, 1, dp(0, 1));
		
		out.flush();
		out.close();
	}
	
	public static int dp(int prev, int idx) {
		if(idx == n)
			return 0;
		if(memo[prev][idx] != -1)
			return memo[prev][idx];
		int leave = dp(prev, idx+1);
		int take = 0;
		if(arr.get(idx).w > arr.get(prev).w && arr.get(idx).s < arr.get(prev).s)
			take = 1 + dp(idx, idx+1);
		return memo[prev][idx] = Math.max(take, leave);
	}
	
	public static void printSol(int prev, int idx, int count) {
		if(idx == n || count == 0)
			return;
		int leave = dp(prev, idx+1);
		int take = 0;
		if(arr.get(idx).w > arr.get(prev).w && arr.get(idx).s < arr.get(prev).s)
			take = 1 + dp(idx, idx+1);
		if(memo[prev][idx] == take) {
			out.println(arr.get(idx).pos);
			printSol(idx, idx+1, --count);
		}
		else {
			printSol(prev, idx+1, count);
		}
	}
	
	static class Elephant implements Comparable<Elephant>{
		int w, s, pos;
		
		public Elephant(int a, int b, int c) {
			w = a;
			s = b;
			pos = c;
		}
		
		public int compareTo(Elephant b) {
			int r = w - b.w;
			if(r == 0)
				r = b.s - s;
			return r;
		}
		
		public String toString() {
			return w + " " + s;
		}
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