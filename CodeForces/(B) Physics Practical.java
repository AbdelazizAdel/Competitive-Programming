import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class zizo {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileReader("input.txt"));
		PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
		int n = sc.nextInt();
		int[] count = new int[5001];
		for(int i = 0; i < n; i++)
			count[sc.nextInt()]++;
		int ans = Integer.MAX_VALUE;
		for(int i = 1; i <= 5000; i++) {
			int sum = 0;
			for(int j = 1; j <= 5000; j++)
				if(j < i || j > 2 * i)
					sum+=count[j];
			ans = Math.min(ans, sum);
		}
		out.println(ans);
		out.flush();
		out.close();
	}
	
//	static class Scanner 
//	{
//		StringTokenizer st;
//		BufferedReader br;
//
//		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
//
//		public String next() throws IOException 
//		{
//			while (st == null || !st.hasMoreTokens()) 
//				st = new StringTokenizer(br.readLine());
//			return st.nextToken();
//		}
//
//		public int nextInt() throws IOException {return Integer.parseInt(next());}
//
//		public long nextLong() throws IOException {return Long.parseLong(next());}
//
//		public String nextLine() throws IOException {return br.readLine();}
//
//		public double nextDouble() throws IOException{return Double.parseDouble(next());}
//
//		public boolean ready() throws IOException {return br.ready();}
//
//	}
}