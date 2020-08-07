import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class zizo5{
	public static void main (String[] args) throws InterruptedException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n = sc.nextInt(), k = sc.nextInt();
		int energy[] = new int[n];
		for(int i = 0; i < n; i++)
			energy[i] = sc.nextInt();
		System.out.println(BS(energy, k));
		
		out.flush();
		out.close();
	}
	
	public static double BS(int[] energy, int k) {
		double low = 0.0, high = 1000.0, ans = 0.0;
		while(high-low>1e-6) {
			double mid = (low + high)/2;
			if(can(energy, k, mid)) {
				ans = mid;
				low = mid;
			}
			else
				high = mid;
		}
		return ans;
	}
	
	public static boolean can(int[] energy, int k, double x) {
		double sum = 0, per = k*1.0/100;
		for(int i = 0; i < energy.length; i++) {
			if(energy[i] >= x)
				sum+=(energy[i]-x)*(1-per);
			else 
				sum-=(x-energy[i]);
		}
		return sum<-1e-6?false:true;
	}

	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			if (st == null || !st.hasMoreTokens()) 
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