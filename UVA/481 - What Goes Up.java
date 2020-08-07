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
	static ArrayList<ArrayList<E>> L;
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		Thread.sleep(3000);
		ArrayList<Integer> arr = new ArrayList<Integer>();
		while(sc.ready()) {
			arr.add(sc.nextInt());
		}
		L = new ArrayList<ArrayList<E>>();
		for(int i = 0; i < arr.size(); i++) {
			int x = arr.get(i);
			int pos = BS(x);
			if(pos != -1)
				L.get(pos).add(new E(i, x));
			else {
				L.add(new ArrayList<E>());
				L.get(L.size()-1).add(new E(i, x));
			}	
		}
		StringBuilder sb = new StringBuilder(L.get(L.size()-1).get(L.get(L.size()-1).size()-1).val+"\n");
		int lastPos = L.get(L.size()-1).get(L.get(L.size()-1).size()-1).idx;
		for(int i = L.size()-2; i >= 0; i--) {
			ArrayList<E> a = L.get(i);
			E ans = null;
			for(int j = 0; j < a.size(); j++) 
				if(a.get(j).idx < lastPos)
					ans = a.get(j);
			sb.insert(0, ans.val+"\n");
			lastPos = ans.idx;
		}
		System.out.println(L.size());
		System.out.println("-");
		System.out.print(sb);
		out.flush();
		out.close();
	}
	
	public static int BS(int x) {
		int res = -1;
		int low = 0;
		int high = L.size()-1;
		while(low <= high) {
			int mid = (low + high) / 2;
			ArrayList<E> a = L.get(mid);
			if(a.get(a.size()-1).val >= x) {
				res = mid;
				high = mid - 1;
			}
			else
				low = mid + 1;
		}
		return res;
	}
	
	static class E{
		int idx, val;
		
		public E(int a, int b) {
			idx = a;
			val = b;
		}
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