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
	
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		Thread.sleep(3000);
		while(sc.ready()) {
			int x = 0;
			ArrayList<BigInteger> arr = new ArrayList<BigInteger>();
			while((x = sc.nextInt()) != -999999) {
				BigInteger y = new BigInteger(x+"");
				arr.add(y);
			}
			BigInteger max = new BigInteger("-1000000");
			for(int i = 0; i < arr.size(); i++) {
				for(int j = i; j < arr.size(); j++) {
					BigInteger val = BigInteger.ONE;
					for(int k = i; k <= j; k++)
						val = val.multiply(arr.get(k));
					if(max.compareTo(val) == -1)
						max = new BigInteger(val.toString());
				}
			}
			out.println(max);
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