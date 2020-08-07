import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		TreeMap<String, Integer> tree = new TreeMap();
		while(n-->0) {
			st = new StringTokenizer(br.readLine());
			tree.put(st.nextToken(), Integer.parseInt(st.nextToken()));
		}
		while(m>0) {
			int sum = 0;
			while(true) {
				String x = br.readLine();
				if(x.equals("."))
					break;
				st = new StringTokenizer(x);
				while(st.hasMoreTokens()) {
					String y = st.nextToken();
					if(tree.containsKey(y))
						sum+=tree.get(y);
				}
			}
			out.println(sum);
			m--;
		}
		out.flush();
		out.close();
	}
}
	
	
