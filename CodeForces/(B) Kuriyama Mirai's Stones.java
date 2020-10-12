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
		int n = sc.nextInt();
		int[] arr_1 = new int[n], arr_2 = new int[n];
		for(int i = 0; i < n; i++) {
			int x = sc.nextInt();
			arr_1[i] = arr_2[i] = x;
		}
		shuffle(arr_2);
		Arrays.sort(arr_2);
		long[] sum_1 = new long[n], sum_2 = new long[n];
		for(int i = 0 ; i < n; i++) {
			if(i > 0) {
				sum_1[i]+=sum_1[i - 1];
				sum_2[i]+=sum_2[i - 1];
			}
			sum_1[i]+=arr_1[i];
			sum_2[i]+=arr_2[i];
		}
		int m = sc.nextInt();
		for(int i = 0; i < m; i++) {
			int type = sc.nextInt(), l = sc.nextInt() - 1, r = sc.nextInt() - 1;
			if(type == 1)
				out.println(sum_1[r] - (l > 0 ? sum_1[l - 1] : 0));
			else
				out.println(sum_2[r] - (l > 0 ? sum_2[l - 1] : 0));

		}
		out.flush();
		out.close();
	}
	
	public static void shuffle(int[] arr) {
		Random rand = new Random();
		for(int i = arr.length - 1; i >= 0; i--) {
			int temp = arr[i];
			int idx = rand.nextInt(i + 1);
			arr[i] = arr[idx];
			arr[idx] = temp;
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