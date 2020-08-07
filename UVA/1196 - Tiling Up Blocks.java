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
	static Block[] arr;
	static int memo[][][], n;
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		while(true) {
			n = sc.nextInt();
			if(n == 0)
				break;
			arr = new Block[n];
			for(int i = 0; i < n; i++)
				arr[i] = new Block(sc.nextInt(), sc.nextInt());
			Arrays.sort(arr);
			memo = new int[101][101][n];
			for(int[][] a: memo)
				for(int[] b: a)
				Arrays.fill(b, -1);
			out.println(dp(0, 0, 0));
		}
		out.println("*");
		
		out.flush();
		out.close();
	}
	
	public static int dp(int l, int m, int idx) {
		if(idx == n)
			return 0;
		if(memo[l][m][idx] != -1)
			return memo[l][m][idx];
		int leave = dp(l, m, idx+1);
		int take = 0;
		if(arr[idx].l >= l && arr[idx].m >= m)
			take = 1 + dp(arr[idx].l, arr[idx].m, idx+1);
		return memo[l][m][idx] = Math.max(take, leave);
	}
	
	static class Block implements Comparable<Block>{
		int l, m;
		
		public Block(int a, int b) {
			l = a;
			m = b;
		}
		
		public int compareTo(Block b) {
			int r = l - b.l;
			if(r == 0)
				r = m - b.m;
			return r;
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