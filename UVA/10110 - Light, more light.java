import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class zizo5{
	public static void main (String[] args) throws InterruptedException, IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		ArrayList<Integer> primes = new ArrayList<Integer>(300);
		for(int i = 2; i <= 65535; i++) {
			boolean found = false;
			int limit = (int) Math.sqrt(i);
			for(int j = 2; j <= limit; j++) {
				if(i%j == 0) {
					found = true;
					break;
				}
			}
			if(!found)
				primes.add(i);
		}
		
		while(true) {
			long n = sc.nextLong();
			if(n == 0)
				break;
			if(n == 1) {
				out.println("yes");
				continue;
			}
			int limit = (int) Math.sqrt(n), count = 1, idx = 0;
			TreeMap<Long, Integer> map = new TreeMap();
			while(n > 1 && primes.get(idx) <= limit) {
				long prime = primes.get(idx);
				if(n % prime == 0) {
					if(map.containsKey(prime))
						map.put(prime, map.get(prime)+1);
					else
						map.put(prime, 2);
					n/=prime;
				}
				else
					idx++;
				if(idx == primes.size())
					break;
			}
			if(n != 1)
				map.put(n, 2);
			if(map.isEmpty())
				count = 2;
			while(!map.isEmpty())
				count*=map.pollFirstEntry().getValue();
			out.println(count % 2 == 0? "no" : "yes");
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