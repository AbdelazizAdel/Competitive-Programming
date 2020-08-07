import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class zizo2{
	
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder sb = new StringBuilder();
		
		int t = sc.nextInt();
		while(t-->0) {
			sc.nextLine();
			String x = sc.nextLine();
			int n = x.length();
			int[][] rect = new int[n][n];
			rect[0][0] = Integer.parseInt(x.charAt(0)+"");
			for(int i = 1; i < n; i++)
				rect[0][i] = Integer.parseInt(x.charAt(i)+"") + rect[0][i-1];
			for(int i = 1; i < n; i++) {
				x = sc.nextLine();
				for(int j = 0; j < n; j++) {
					rect[i][j] = Integer.parseInt(x.charAt(j)+"");
					if(i > 0)
						rect[i][j]+=rect[i-1][j];
					if(j > 0)
						rect[i][j]+=rect[i][j-1];
					if(i > 0 && j > 0)
						rect[i][j]-=rect[i-1][j-1];
				}
			}
			int max = 0, val = 0;
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					for(int a = i; a < n; a++)
						for(int b = j; b < n; b++) {
							val = rect[a][b];
							if(i > 0)
								val-=rect[i-1][b];
							if(j > 0)
								val-=rect[a][j-1];
							if(i > 0 && j > 0)
								val+=rect[i-1][j-1];
							int area = (a-i+1)*(b-j+1);
							if(val == area)
								max = Math.max(max, val);
						}
			if(t != 0)
				sb.append(max+"\n\n");
			else
				sb.append(max);
		}
		System.out.println(sb);
		
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