import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class zizo {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = sc.nextInt();
		int k1 = sc.nextInt();
		ArrayList<Integer> one = new ArrayList();
		for(int i = 0; i < k1; i++)
			one.add(sc.nextInt());
		int k2 = sc.nextInt();
		ArrayList<Integer> two = new ArrayList();
		for(int i = 0; i < k2; i++)
			two.add(sc.nextInt());
		HashSet<Long> set = new HashSet();
		int num = 0, win = 0;
		while(true) {
			if(one.size() == 0) {
				win = 2;
				break;
			}
			if(two.size() == 0) {
				win = 1;
				break;
			}
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < one.size(); i++)
				sb.append(one.get(i));
			sb.append(55);
			for(int i = 0; i < two.size(); i++)
				sb.append(two.get(i));
			long l = Long.parseLong(sb.toString());
			if(set.contains(l))
				break;
			else
				set.add(l);
			fight(one, two);
			num++;
		}
		if(win == 0)
			out.println(-1);
		else
			out.printf("%d %d%n", num, win);
		out.flush();
		out.close();
	}
	
	
	public static void fight(ArrayList<Integer> one, ArrayList<Integer> two) {
		if(one.get(0) > two.get(0)) {
			one.add(two.get(0));
			one.add(one.get(0));
		}
		else {
			two.add(one.get(0));
			two.add(two.get(0));
		}
		one.remove(0);
		two.remove(0);
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