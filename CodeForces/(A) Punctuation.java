import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder s = new StringBuilder();
		while(st.hasMoreTokens()) {
			String x = st.nextToken();
			if(s.length()!=0 && s.charAt(s.length()-1)!=' ' && isLetter(x.charAt(0)))
				s.append(" ");
			for(int i = 0 ; i<x.length(); i++) {
				s.append(x.charAt(i));
				if(!isLetter(x.charAt(i)))
					s.append(" ");
			}
		}
		out.println(s.toString());
		out.flush();
	}
	
	public static boolean isLetter(char c) {
		return c>='a' && c<='z';
	}
}