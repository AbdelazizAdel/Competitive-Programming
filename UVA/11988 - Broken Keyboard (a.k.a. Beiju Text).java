import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(5000);
		while(br.ready()) {
			String s = br.readLine();
			LinkedList<Character> l = new LinkedList();
			LinkedList<Character> l2 = new LinkedList();
			boolean last = true;
			for(int i = 0; i<s.length(); i++) {
				if(s.charAt(i)=='[') {
					if(!last)
						l.addAll(0,l2);
					l2.clear();
					last = false;
				}
				else if(s.charAt(i)==']') {
					last = true;
					l.addAll(0,l2);
					l2.clear();
				}
				else if(last)
					l.add(s.charAt(i));
				else
					l2.add(s.charAt(i));
			}
			if(!l2.isEmpty())
				l.addAll(0,l2);
			for(Character c: l)
				out.print(c);
			out.println();
		}
		out.flush();
		out.close();
	}
		
}
	
	
