import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		TreeSet<String> ts = new TreeSet();
		//Thread.sleep(5000);
		while(br.ready()) {
			String s = br.readLine().toLowerCase().replaceAll("[^a-z]", " ");
			StringTokenizer st = new StringTokenizer(s);
			while(st.hasMoreTokens())
				ts.add(st.nextToken());
		}
		for(String s:ts)
			out.println(s);
		out.flush();
		out.close();
	}
	
}
	
	
