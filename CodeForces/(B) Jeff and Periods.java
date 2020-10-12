import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class zizo {
	static final long pow = 31, pow_3 = (int) Math.pow(pow, 3);
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		TreeMap<Integer, Pair> map = new TreeMap();
		int count = 0;
		for(int i = 0; i < n; i++) {
			if(!map.containsKey(a[i])) {
				map.put(a[i], new Pair(0, i));
				count++;
			}
			else {
				if(map.get(a[i]).d == -1)
					continue;
				else if(map.get(a[i]).d == 0)
					map.get(a[i]).d = i - map.get(a[i]).p;
				else if(a[i - map.get(a[i]).d] != a[i]) {
					map.get(a[i]).d = -1;
					count--;
				}
			}
		}
		out.println(count);
		for(Map.Entry<Integer, Pair> e : map.entrySet())
			if(e.getValue().d != -1)
				out.println(e.getKey() + " " + e.getValue().d);
		out.flush();
		out.close();
	}
	
	static class Pair {
		int d, p;
		
		public Pair(int a, int b) {
			this.d = a;
			this.p = b;
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