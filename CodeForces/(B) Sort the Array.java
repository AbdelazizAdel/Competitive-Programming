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
		int[] arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		if(n < 2)
			out.printf("yes%n%d %d%n", 1, n);
		else {
			int inc = n, dec = n, count = 0;
			boolean status = true;
			if(arr[0] > arr[1]) {
				status = false;
				dec = 0;
			}
			else
				inc = 0;
			for(int i = 1; i < n -1; i++) {
				if(status && arr[i] > arr[i + 1]) {
					dec = i;
					status = false;
					count++;
				}
				else if(!status && arr[i] < arr[i + 1]) {
					status = true;
					inc = i;
					count++;
				}
			}
			if(count > 2)
				out.println("no");
			else if(inc == 0 && dec == n)
				out.println("yes\n1 1");
			else if(inc == n && dec == 0)
				out.printf("yes%n%d %d%n", 1, n);
			else if(count == 2 && inc > dec && arr[inc] > arr[dec - 1] && arr[dec] < arr[inc + 1])
				out.printf("yes%n%d %d", dec + 1, inc + 1);
			else if(count == 1 && dec == 0 && arr[0] < arr[inc + 1])
				out.printf("yes%n%d %d%n", 1, inc + 1);
			else if(count == 1 && inc == 0 && arr[n - 1] > arr[dec - 1])
				out.printf("yes%n%d %d%n", dec + 1, n);
			else
				out.println("no");				
		}
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