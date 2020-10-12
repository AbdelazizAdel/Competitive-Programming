import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class zizo {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		String s = sc.nextLine();
		if(s.length() < 26) {
			System.out.println(-1);
			return;
		}
		boolean possible = false;
		TreeSet<Character> set= new TreeSet();
		int free = 0;
		for(int j = 0; j <= s.length() - 26; j++) {
			free = 0;
			for(int i = 0; i < 26; i++)
				set.add((char)('A' + i));
			for(int i = j; i < j + 26; i++) {
				if(s.charAt(i) == '?') {
					free++;
					continue;
				}
				set.remove(s.charAt(i));
			}
			if(set.size() == free) {
				possible = true;
				free = j;
				break;
			}
		}
		if(!possible)
			System.out.println(-1);
		else {
			String ans = "";
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) != '?') {
					ans+=s.charAt(i);
					continue;
				}
				if(i >= free && i < free + 26)
					ans+=set.pollFirst();
				else
					ans+='A';
			}
			System.out.println(ans);
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