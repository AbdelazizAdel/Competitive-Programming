import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			boolean[] d = new boolean[n];
			boolean[] taken = new boolean[n+1];
			for(int i = 0; i < n; i++) {
				String[] arr = sc.nextLine().split(" ");
				if(Integer.parseInt(arr[0]) == 0) {
					d[i] = false;
					continue;
				}
				for(int j = 1; j <= Integer.parseInt(arr[0]); j++) {
					if(!taken[Integer.parseInt(arr[j])]) {
						taken[Integer.parseInt(arr[j])] = true;
						d[i] = true;
						break;
					}
				}		
			}
			int ans = -1;
			for(int i = 1; i <= n; i++)
				if(!taken[i]) {
					ans = i;
					break;
				}
			int ans2 = -1;
			for(int i = 0; i < n; i++)
				if(!d[i]) {
					ans2 = i+1;
					break;
				}
			
			if(ans == -1)
				out.println("OPTIMAL");
			else
				out.println("IMPROVE\n"+ ans2+" "+ans);
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
