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
		
		int N = sc.nextInt();
		while(N-->0) {
			StringBuilder sb = new StringBuilder();
			int P = sc.nextInt();
			ArrayList<Integer> adjList[] = new ArrayList[P];
			for(int i = 0; i < P; i++)
				adjList[i] = new ArrayList<Integer>();
			int min = P;
			for(int i = 0; i < P; i++) {
				StringTokenizer st = new StringTokenizer(sc.nextLine());
				min = Math.min(min, st.countTokens());
				while(st.hasMoreTokens())
					adjList[i].add(Integer.parseInt(st.nextToken()));
			}
			for(int i = 0; i < P; i++)
				if(adjList[i].size() == min)
					sb.append((i+1)+" ");
			out.println(sb.deleteCharAt(sb.length()-1).toString());
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