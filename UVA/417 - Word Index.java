import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		Queue<String> q = new LinkedList<String>();
		TreeMap<String, Integer> t = new TreeMap();
		int idx = 1;
		for(char c = 'a'; c<='z'; c++)
			q.add(c+"");
		while(!q.isEmpty()) {
			String cur = q.remove();
			t.put(cur, idx++);
			if(cur.length()<5)
				for(char c = (char)(cur.charAt(cur.length()-1)+1); c<='z'; c++)
					q.add(cur+c);
		}
		while(br.ready()) {
			String in = br.readLine();
			if(!t.containsKey(in))
				out.println(0);
			else
				out.println(t.get(in));
		}
		out.flush();
		out.close();
	}
	
}
	
	
