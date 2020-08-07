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
			int N = sc.nextInt(), M = sc.nextInt();
			int[][] matrix = new int[N][N];
			for(int i = N-1; i >= 0; i--)
				for(int j = 0; j < N; j++)
					matrix[i][j] = sc.nextInt();
			sc.nextLine();
			for(int i = 0; i < N; i++)
				for(int j = 0; j < N; j++) {
					if(i > 0)
						matrix[i][j]+=matrix[i-1][j];
					if(j > 0)
						matrix[i][j]+=matrix[i][j-1];
					if(i > 0 && j > 0)
						matrix[i][j]-=matrix[i-1][j-1];
				}
			int ans[][] = new int[N-M+1][N-M+1], val = 0;
			int x = 0, y = 0;
			for(int i = 0; i < (N-M+1); i++)
				for(int j = 0; j < (N-M+1); j++) {
					x = i + M - 1;
					y = j + M - 1;
					val = matrix[x][y];
					if(i > 0)
						val-=matrix[i-1][y];
					if(j > 0)
						val-=matrix[x][j-1];
					if(i > 0 && j > 0)
						val+=matrix[i-1][j-1];
					ans[i][j] = val;
				}
			long sum = 0;
			for(int i = N-M; i >= 0; i--)
				for(int j = 0; j < N-M+1; j++) {
					out.println(ans[i][j]);
					sum+=ans[i][j];
				}
			out.println(sum);
			if(sc.ready())
				out.println();
			
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