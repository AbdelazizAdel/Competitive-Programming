import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		//Thread.sleep(5000);
		String x = br.readLine().toLowerCase();
		while(br.ready())
			x+=" "+br.readLine().toLowerCase();
		x = x.replaceAll("- ","");
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<x.length(); i++)
			if(x.charAt(i)=='-' || (x.charAt(i)>='a' && x.charAt(i)<='z'))
				sb.append(x.charAt(i));
			else
				sb.append(" ");
		x = sb.toString().replaceAll(" +", " ");
		TreeSet<String> tree = new TreeSet();
		StringTokenizer st = new StringTokenizer(x);
		while(st.hasMoreTokens())
			tree.add(st.nextToken());
		while(tree.size()>0)
			out.println(tree.pollFirst());
		out.flush();
		out.close();
	}
}
	
	
