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
	static int memo[][][], n;
	static Dims[] blocks;
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int t = 0;
		while(true) {
			n = sc.nextInt();
			if(n == 0)
				break;
			blocks = new Dims[n+1];
			blocks[n] = new Dims(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
			for(int i = 0; i < n; i++)
				blocks[i] = new Dims(sc.nextInt(), sc.nextInt(), sc.nextInt());
			memo = new int[n+1][3][3];
			for(int[][] a: memo)
				for(int[] b: a)
					Arrays.fill(b, -1);
			out.printf("Case %d: maximum height = %d%n", ++t, dp(n, 0, 0));
		}

		out.flush();
		out.close();
	}

	public static int dp(int idx, int d1, int d2) {
		if(memo[idx][d1][d2] != -1)
			return memo[idx][d1][d2];
		int ret = 0;
		for(int i = 0; i < n; i++) {
			int take = 0;
			ArrayList<Quad> res = newBase(blocks[idx].get(d1), blocks[idx].get(d2), i);
			while(res.size() > 0) {
				Quad x = res.remove(res.size()-1);
				take = blocks[i].get(x.h) + dp(i, x.w, x.l);
				ret = Math.max(ret, take);
			}
		}
		if(ret == 0)
			return 0;
		return memo[idx][d1][d2] = ret;

	}

	public static ArrayList<Quad> newBase(int d1, int d2, int i) {
		int x = blocks[i].d1, y = blocks[i].d2, z = blocks[i].d3;
		ArrayList<Quad> res = new ArrayList<>(); 
		if(x < d1) {
			if(y < d2)
				res.add(new Quad(i, 0, 1, 2));
			if(z < d2)
				res.add(new Quad(i, 0, 2, 1));
		}
		if(y < d1) {
			if(x < d2)
				res.add(new Quad(i, 1, 0, 2));
			if(z < d2)
				res.add(new Quad(i, 1, 2, 0));
		}
		if(z < d1) {
			if(x < d2)
				res.add(new Quad(i, 2, 0, 1));
			if(y < d2)
				res.add(new Quad(i, 2, 1, 0));
		}
		return res;
	}

	static class Dims{
		int d1, d2, d3;

		public Dims(int a, int b, int c) {
			d1 = a;
			d2 = b;
			d3 = c;
		}

		public int get(int idx) {
			switch(idx) {
			case 0: return d1;
			case 1: return d2;
			case 2: return d3;
			}
			return 0;
		}
	}

	static class Quad{
		int idx, w, l, h;

		public Quad(int a, int b, int c, int d) {
			idx = a;
			w = b;
			l = c;
			h = d;
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