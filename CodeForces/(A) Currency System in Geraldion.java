import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int res = 1;
		for(int i = 0 ; i<n; i++) {
			int x = Integer.parseInt(st.nextToken());
			if(x==1) {
				res = -1;
				break;
			}
		}
		out.println(res);
		out.flush();
		out.close();
	}
	
}