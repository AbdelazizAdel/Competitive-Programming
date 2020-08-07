import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class zizo2{
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int b = sc.nextInt();
		for(int k = 1; k <= b; k++) {
			int s = sc.nextInt();
			int[] roads = new int[s-1];
			for(int i = 0; i < s-1; i++)
				roads[i] = sc.nextInt();
			int ans = 0, sum = 0, start = 0, end = 0, len = 0, counter = 0;
			for(int i = 0; i < s-1; i++) {
				sum+=roads[i];
				if(sum > ans) {
					ans = sum;
					end = i;
					start = counter;
					len = i - counter + 1;
				}
				else if (sum == ans) {
					if(i - counter + 1 > len) {
						start = counter;
						end = i;
						len = i - counter + 1;
					}	
				}
				else if(sum < 0){
					sum = 0;
					counter = i+1;
				}
			}
			if(ans == 0)
				System.out.printf("Route %d has no nice parts%n", k);
			else
				System.out.printf("The nicest part of route %d is between stops %d and %d%n", k, start+1, end+2);
		}
		
		out.flush();
		out.close();
 	}


	static class Scanner {
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