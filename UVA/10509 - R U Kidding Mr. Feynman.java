import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		TreeMap<Integer, Integer> map = new TreeMap();
		for(int i = 0; i < 101; i++)
			map.put(cube(i), i);
		while(true) {
			double x = sc.nextDouble();
			if(x == 0)
				break;
			Map.Entry<Integer, Integer> e = map.floorEntry((int)x);
			double dx = (x - e.getKey()) / (3 * e.getValue() * e.getValue());
			out.printf("%.4f%n", e.getValue() + dx);
		}
 		out.flush();
		out.close();
	}
	
	public static int cube(int x) {
		return x * x * x;
	}
	
	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}
