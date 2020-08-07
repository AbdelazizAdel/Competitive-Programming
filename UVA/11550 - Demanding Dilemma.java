import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class zizo7 {
	static int[] schedule;
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt(), m = sc.nextInt();
			int[][] matrix = new int[n][m];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < m; j++)
					matrix[i][j] = sc.nextInt();
			boolean possible = true;
			for(int i = 0; i < m; i++) {
				int count = 0;
				for(int j = 0; j < n; j++)
					if(matrix[j][i] == 1)
						count++;
				if(count != 2)
					possible = false;
			}
			if(!possible)
				out.println("No");
			else {
				boolean check = true;
				for(int i = 0; i < n-1; i++) {
					for(int j = i+1; j < n; j++) {
						int count = 0;
						for(int k = 0; k < m; k++) 
							if(matrix[i][k] == 1 && matrix[j][k] == 1)
								count++;
						if(count > 1)
							check = false;
					}
				}
				out.println(check?"Yes":"No");
			}
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