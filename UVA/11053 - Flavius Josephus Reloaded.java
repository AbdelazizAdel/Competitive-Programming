import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class zizo {
	static long[] powers;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		while(true) {
			int N = sc.nextInt();
			if(N == 0)
				break;
			int a = sc.nextInt(), b = sc.nextInt();
			ArrayList<Integer> rem = new ArrayList();
			HashSet<Integer> set = new HashSet();
			long cur = 0l, cnt = 0;
			while(!set.contains((int)cur)) {
				set.add((int)cur);
				rem.add((int)cur);
				cur = (((((a % N) * (cur % N)) % N) * (cur % N)) % N + (b % N)) % N;
				cnt++;
			}
			int pos = 0;
			for(int i = 0; i < rem.size(); i++)
				if(rem.get(i) == cur) {
					pos = i;
					break;
				}
			out.println(N - cnt + pos);
		}
		out.flush();
		out.close();
	}
	
	public static long pow(long b, int p) {
		if(p == 0)
			return powers[p] = 1;
		return powers[p] = b * pow(b, p - 1); 
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