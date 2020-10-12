import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt(), t = sc.nextInt();
		Pair[] wastes = new Pair[k];
		for(int i = 0; i < k; i++) {
			int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
			wastes[i] = new Pair(a, b); 
		}
		Arrays.sort(wastes);
		String[] crops = {"Grapes", "Carrots", "Kiwis"};
		while(t-- > 0) {
			int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
			Pair p = new Pair(a, b);
			if(contains(p, wastes)) {
				out.println("Waste");
				continue;
			}
			int num = 0;
			for(int i = 0; i < k; i++)
				if(p.compareTo(wastes[i]) > 0)
					num++;
			out.println(crops[(a * m  + b + 1 - num) % 3]);
		}
		out.flush();
		out.close();
	}
	
	public static boolean contains(Pair p, Pair[] arr) {
		int low = 0, high = arr.length - 1;
		while(low <= high) {
			int mid = low + (high - low) / 2;
			if(p.compareTo(arr[mid]) == 0)
				return true;
			if(p.compareTo(arr[mid]) < 0)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return false;
	}
	
	static class Pair implements Comparable<Pair> {
		int a, b;
		
		public Pair(int x, int y) {
			a = x;
			b = y;
		}
		
		public int compareTo(Pair p) {
			if(a != p.a)
				return a - p.a;
			if(b != p.b)
				return b - p.b;
			return 0;
		}
		
		public String toString() {
			return a + " " + b;
		}
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