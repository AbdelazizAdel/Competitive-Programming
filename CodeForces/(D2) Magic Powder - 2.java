import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class zizo5{
	static PriorityQueue<I> ing;
	public static void main (String[] args) throws InterruptedException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		int n = sc.nextInt(), k = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for(int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		for(int i = 0; i < n; i++)
			b[i] = sc.nextInt();
		ing = new PriorityQueue<I>();
		for(int i = 0; i < n; i++)
			ing.add(new I(a[i], b[i], b[i]/a[i]));
		long sum = 0, min = ing.peek().n, ans = min;
		while(!ing.isEmpty() && ing.peek().n == min) {
			I x = ing.poll();
			sum+=x.a;
			k+=x.b % x.a;
		}

		while(!ing.isEmpty()) {
			min = ing.peek().n;
			if(k/sum < min-ans) {
				ans+=k/sum;
				k = (int) (k%sum);
				break;
			}
			else if(k/sum == min-ans) {
				ans = min;
				k = (int) (k%sum);
				break;
			}
			else {
				k-=sum*(min-ans);
				ans = min;
			}	
			while(!ing.isEmpty() && ing.peek().n == min) {
				I x = ing.poll(); 
				sum+=x.a;
				k+=x.b % x.a;
			}

		}
		ans+=k/sum;
		out.println(ans);

		out.flush();
		out.close();
	}

	static class I implements Comparable<I>{
		int a, b, n;
		boolean taken;
		public I(int x, int y, int z) {
			a = x;
			b = y;
			n = z;
		}

		@Override
		public int compareTo(I i) {
			// TODO Auto-generated method stub
			return n - i.n;
		}
		public String toString() {
			return "("+a+", "+b+", "+n+")";
		}
	}

	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			if (st == null || !st.hasMoreTokens()) 
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