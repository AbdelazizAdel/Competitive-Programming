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
		long num = sc.nextLong();
		int[] cnt = new int[10];
		while(num != 0) {
			int digit = (int)(num % 10);
			num/=10;
			while(digit > 1) 
				cnt[digit--]++;
		}
		cnt[2] = cnt[2] + cnt[4] * 2 + cnt[6] + cnt[8] * 3;
		cnt[3] = cnt[3] + cnt[6] + cnt[9] * 2;
		cnt[4] = cnt[6] = cnt[9] = cnt[8] = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 7; i > 1; i--) {
			int j = cnt[i];
			while(j-- > 0) {
				sb.append(i + "");
				if(i == 7) {
					cnt[5]--;
					cnt[3]-=2;
					cnt[2]-=4;
				}
				if(i == 5) {
					cnt[3]--;
					cnt[2]-=3;
				}
				if(i == 3)
					cnt[2]--;
			}
		}
		out.println(sb);
		out.flush();
		out.close();
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