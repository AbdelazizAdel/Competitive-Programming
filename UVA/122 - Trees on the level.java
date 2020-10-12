import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder sb = new StringBuilder();
		while(sc.ready()) {
			TreeSet<Pair>[] lvls = new TreeSet[256];
			for(int i = 0; i < 256; i++)
				lvls[i] = new TreeSet<Pair>();
			int max = -1;
			sb = new StringBuilder();
			boolean repeated = false;
			while(true) {
				String s = sc.next();
				if(s.equals("()"))
					break;
				String[] arr = s.substring(1, s.length() - 1).split(",");
				int lvl = arr.length == 1 ? 0 : arr[1].length();
				if(lvls[lvl].contains(new Pair(0, arr.length == 1 ? "" : arr[1])))
					repeated = true;
				lvls[lvl].add(new Pair(Integer.parseInt(arr[0]), arr.length == 1 ? "" : arr[1]));
				max = Math.max(max, lvl);
			}
			if(repeated) {
				out.println("not complete");
				continue;
			}
			outer:for(int i = 0; i <= max; i++) {
				if(i == 0 && lvls[i].size() != 0)
					sb.append(lvls[0].first().val + (i == max ? "\n" : " "));
				else {
					Iterator<Pair> it = lvls[i].iterator();
					while(it.hasNext()) {
						Pair p = it.next();
						String prefix = p.path.substring(0, p.path.length() - 1);
						if(lvls[i - 1].contains(new Pair(0, prefix)))
							sb.append(p.val + (i == max && !it.hasNext() ? "\n" : " "));
						else {
							sb = new StringBuilder("not complete\n");
							break outer;
						}		
					}
				}
			}
			out.print(sb.toString());
		}
		out.flush();
		out.close();
	}

	static class Pair implements Comparable<Pair> {
		int val;
		String path;
		
		public Pair(int a, String b) {
			val = a;
			path = b;
		}
		
		public int compareTo(Pair p) { return path.compareTo(p.path); }
		
		public boolean equals(Pair p) { return this.compareTo(p) == 0; }
		
		public String toString() { return val + " " + path + " "  + path.length(); }
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