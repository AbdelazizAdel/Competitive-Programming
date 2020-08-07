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
		
		int t = sc.nextInt();
		while(t-->0) {
			int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
			long[][][] heap = new long[a][b][c];
			for(int i = 0; i < a; i++) {
				for(int j = 0; j < b; j++) {
					for(int k = 0; k < c; k++) {
						heap[i][j][k] = sc.nextLong();
						if(i > 0)
							heap[i][j][k]+=heap[i-1][j][k];
						if(j > 0)
							heap[i][j][k]+=heap[i][j-1][k];
						if(k > 0)
							heap[i][j][k]+=heap[i][j][k-1];
						if(i > 0 && j >0)
							heap[i][j][k]-=heap[i-1][j-1][k];
						if(i > 0 && k > 0)
							heap[i][j][k]-=heap[i-1][j][k-1];
						if(j > 0 && k > 0)
							heap[i][j][k]-=heap[i][j-1][k-1];
						if(i > 0 && j > 0 && k > 0)
							heap[i][j][k]+=heap[i-1][j-1][k-1];
					}
				}
			}
			long max = Long.MIN_VALUE;
			for(int i = 0; i < a; i++)
				for(int j = 0; j < b; j++)
					for(int k = 0; k < c; k++)
						for(int x = i; x < a; x++)
							for(int y = j; y < b; y++)
								for(int z = k; z < c; z++) {
									long val = heap[x][y][z];
									if(i > 0)
										val-=heap[i-1][y][z];
									if(j > 0)
										val-=heap[x][j-1][z];
									if(k > 0)
										val-=heap[x][y][k-1];
									if(i > 0 && j >0)
										val+=heap[i-1][j-1][z];
									if(i > 0 && k > 0)
										val+=heap[i-1][y][k-1];
									if(j > 0 && k > 0)
										val+=heap[x][j-1][k-1];
									if(i > 0 && j > 0 && k > 0)
										val-=heap[i-1][j-1][k-1];
									max = Math.max(max, val);
								}
			out.println(max);
			if(t > 0)
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