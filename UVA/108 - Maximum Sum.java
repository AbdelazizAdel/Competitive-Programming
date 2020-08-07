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
		
		Thread.sleep(3000);
		while(sc.ready()) {
			int N = sc.nextInt();
			int[][] rect = new int[N][N];
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++) {
					rect[i][j] = sc.nextInt();
					if(i > 0)
						rect[i][j]+=rect[i-1][j];
					if(j > 0)
						rect[i][j]+=rect[i][j-1];
					if(i > 0 && j > 0)
						rect[i][j]-=rect[i-1][j-1];
				}
			int max = -128, val = 0;
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++)
					for(int x = i; x < N; x++)
						for(int y = j; y < N; y++) {
							val = rect[x][y];
							if(i > 0)
								val-=rect[i-1][y];
							if(j > 0)
								val-=rect[x][j-1];
							if(i > 0 && j > 0)
								val+=rect[i-1][j-1];
							max = Math.max(max, val);
						}
			out.println(max);
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