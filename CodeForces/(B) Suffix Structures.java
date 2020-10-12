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
		String s = sc.nextLine(), t = sc.nextLine();
		int ans = 0;
		HashMap<Character, Integer> map = new HashMap();
		for(int i = 0; i < s.length(); i++) {
			if(!map.containsKey(s.charAt(i)))
				map.put(s.charAt(i), 1);
			else
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
		}
		for(int i = 0; i < t.length(); i++) {
			if(!map.containsKey(t.charAt(i))) {
				ans = 3;
				break;
			}
			if(map.get(t.charAt(i)) == 1)
				map.remove(t.charAt(i));
			else
				map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
		}
		if(ans == 3) 
			out.println("need tree");
		else if (map.size() > 0 && !check(s, t))
			out.println("both");
		else if(map.size() > 0)
			out.println("automaton");
		else
			out.println("array");
		out.flush();
		out.close();
	}
	
	public static boolean check(String s, String t) {
		int i = 0, j = 0;
		while(i < t.length() && j < s.length()) {
			if(t.charAt(i) == s.charAt(j)) {
				i++;
				j++;
			}
			else
				j++;
		}
		return i == t.length();
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