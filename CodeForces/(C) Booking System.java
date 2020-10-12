import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

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
		Request[] requests = new Request[n];
		for(int i = 0; i < n; i++)
			requests[i] = new Request(sc.nextInt(), sc.nextInt(), i + 1);
		Arrays.sort(requests);
		int k = sc.nextInt();
		TreeMap<Integer, ArrayList<Integer>> tables = new TreeMap();
		for(int i = 0; i < k; i++) {
			int x = sc.nextInt();
			if(tables.containsKey(x))
				tables.get(x).add(i + 1);
			else {
				ArrayList<Integer> list = new ArrayList();
				list.add(i + 1);
				tables.put(x, list);
			}
		}
		ArrayList<Pair> ans = new ArrayList();
		int num = 0, sum = 0;
		for(int i = 0; i < n; i++) {
			Request r = requests[i];
			Integer x = tables.ceilingKey(r.num);
			if(x != null) {
				ans.add(new Pair(r.idx, tables.get(x).remove(tables.get(x).size() - 1)));
				num++;
				sum+=r.money;
				if(tables.get(x).size() == 0)
					tables.remove(x);
			}
		}
		out.println(num + " " + sum);
		for(Pair a : ans)
			out.println(a.a + " " + a.b);
		out.flush();
		out.close();
	}

	
	static class Request implements Comparable<Request> {
		int num, money, idx;
		
		public Request(int a, int b, int c) {
			num = a;
			money = b;
			idx = c;
		}
		
		public int compareTo(Request r) {
			return r.money - money;
		}
	}
	
	 static class Pair implements Comparable<Pair> {
		int a, b;
		
		public Pair(int a, int b) {
			this.a = a;
			this.b= b;
		}
		
		public int compareTo(Pair p) { return a - p.a; }
		
//		public boolean equals(Pair p)
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