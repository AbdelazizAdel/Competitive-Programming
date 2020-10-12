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
		int n = sc.nextInt(), r = sc.nextInt(), avg = sc.nextInt();
		Exam[] exams = new Exam[n];
		for(int i = 0; i < n; i++)
			exams[i] = new Exam(sc.nextInt(), sc.nextInt());
		Arrays.sort(exams);
		long sum = 0l;
		for(Exam e : exams)
			sum+=e.a;
		long limit = avg * 1l * n, ans = 0l;
		for(int i = 0; i < n && sum < limit; i++) {
			long x = Math.min(r - exams[i].a, limit - sum);
			ans+=(x * exams[i].b);
			sum+=x;
		}
		out.println(ans);
		out.flush();
		out.close();
	}
	
	static class Exam implements Comparable<Exam> {
		int a, b;
		
		public Exam(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		public int compareTo(Exam e) {
			return b - e.b;
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