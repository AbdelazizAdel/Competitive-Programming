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

public class ZigZag {
	
	public static int longestZigZag(int[] arr) {
		int[][] memo = new int[arr.length][2];
		for(int[] a: memo)
			Arrays.fill(a, 1);
		for(int i = 1; i < arr.length; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j] && memo[j][0] + 1 > memo[i][1])
					memo[i][1] = memo[j][0] + 1;
				if(arr[i] < arr[j] && memo[j][1] + 1 > memo[i][0])
					memo[i][0] = memo[j][1] + 1;
			}
		}
		int ans = 0;
		for(int i = 0; i < arr.length; i++)
			for(int j = 0; j < 2; j++)
				if(memo[i][j] > ans)
					ans = memo[i][j];
		return ans;
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