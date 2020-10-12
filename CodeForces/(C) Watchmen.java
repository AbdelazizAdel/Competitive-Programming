import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class zizo {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt();
		HashMap<Integer, Integer> Xs = new HashMap(), Ys = new HashMap();
		TreeMap<Pair, Integer> map = new TreeMap();
		long ans = 0l;
		for(int i = 0; i < n; i++) {
			Pair p = new Pair(sc.nextInt(), sc.nextInt());
			map.put(p, map.getOrDefault(p, 0) + 1);
			Xs.put(p.x, Xs.getOrDefault(p.x, 0) + 1);
			ans+=Xs.get(p.x) - 1;
			Ys.put(p.y, Ys.getOrDefault(p.y, 0) + 1);
			ans+=Ys.get(p.y) - 1;
		}
		while(!map.isEmpty()) {
			long x = map.pollFirstEntry().getValue();
			ans-=(x * (x - 1) / 2);
		}
		out.println(ans);
		out.flush();
		out.close();
	}
	
	static class Pair implements Comparable<Pair> {
		int x, y;
		
		public Pair(int a, int b) {
			x = a;
			y = b;
		}
		
		public int compareTo(Pair p) {
			if(x == p.x)
				return y - p.y;
			return x - p.x;
		}
	}
	
	static class Scanner 
	{
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