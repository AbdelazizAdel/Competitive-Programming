import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class zizo5{
	public static void main (String[] args) throws InterruptedException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = sc.nextInt(), m = sc.nextInt();
		ArrayList<Pair> f_boxes = new ArrayList<Pair>(n);
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			if(a != 0)
				f_boxes.add(new Pair(a, i));
		}
		out.println(BS(f_boxes, m));
		
		out.flush();
		out.close();
	}
	
	public static long BS(ArrayList<Pair> al, int m) {
		long low = al.get(al.size()-1).idx+2, high = (long)(1e14 + 1e5), ans = 0;
		while(low <= high) {
			long mid = low + high >> 1;
			ArrayList<Pair> p = new ArrayList<Pair>(al.size());
			for(int i = 0; i < al.size(); i++)
				p.add(new Pair(al.get(i).v, al.get(i).idx));
			if(can(p, m, mid)) {
				ans = mid;
				high = mid-1;
			}
			else
				low = mid+1;
		}
		return ans;
	}
	
	public static boolean can(ArrayList<Pair> p, int m, long t) {
		boolean ans = false;
		for(int i = 0, j = 0; i < m; i++) {
			long cur_t = t;
			boolean first = true;
			while(j < p.size() && cur_t > 0) {
				Pair a = p.get(j);
				cur_t = cur_t - (first?a.idx+1:a.idx-p.get(j-1).idx);
				if(cur_t <= 0)
					break;
				if(cur_t >= a.v) {
					cur_t-=a.v;
					j++;
					if(j == p.size()) {
						ans = true;
						break;
					}
					first = false;	
				}
				else {
					p.get(j).v-=cur_t;
					cur_t = 0;
				}
			}
			if(ans)
				break;
		}
		return ans;
	}
	
	static class Pair{
		int v, idx;
		
		public Pair(int a, int b) {
			v = a;
			idx = b;
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