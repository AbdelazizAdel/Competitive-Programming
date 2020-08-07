import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		String res = "maybe";
		int x_bef = 4127;
		while(n-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(x!=y) {
				res = "rated";
				break;
			}
			if(x>x_bef) 
				res = "unrated";
			x_bef = x;
		}
		out.println(res);
		out.flush();
	}
}