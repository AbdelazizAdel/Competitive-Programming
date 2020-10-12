import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class zizo {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t = sc.nextInt();
		while(t-- > 0) {
			int n = sc.nextInt(), q = sc.nextInt();
			int[] arr = new int[n];
			for(int i = 0; i < n; i++)
				arr[i] = sc.nextInt();
			int prev = 0, idx = 0;
			long ans = 0l;
			while(true) {
				int max = findMax(idx, arr);
				if(idx == arr.length) {
					ans+=arr[prev];
					break;
				}
				else {
					ans+=arr[max];
					idx = max + 1;
				}
				int min = findMin(idx, arr);
				if(idx == arr.length)
					break;
				else {
					ans-=arr[min];
					idx = min + 1;
					prev = min;
				}
			}
			System.out.println(ans);
		}
		out.flush();
		out.close();
	}
	
	public static int findMax(int s, int[] arr) {
		for(int i = s; i < arr.length - 1; i++)
			if(arr[i] > arr[i + 1])
				return i;
		return arr.length - 1;
	}
	
	public static int findMin(int s, int[] arr) {
		for(int i = s; i < arr.length - 1; i++)
			if(arr[i] < arr[i + 1])
				return i;
		return arr.length - 1;
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