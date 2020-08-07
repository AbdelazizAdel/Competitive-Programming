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
		
//		Thread.sleep(3000);
		while(sc.ready()) {
			int n = sc.nextInt(), m = sc.nextInt();
			ArrayList<Integer> adjList[] = new ArrayList[(int)1e6+1];
			for(int i = 0; i < (int)1e6; i++)
				adjList[i] = new ArrayList<Integer>();
			for(int i = 1; i <= n; i++)
				adjList[sc.nextInt()].add(i);
			for(int i = 0; i < m; i++) {
				int k = sc.nextInt(), v = sc.nextInt();
				if(adjList[v].size() < k)
					out.println(0);
				else
					out.println(adjList[v].get(k-1));
			}
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