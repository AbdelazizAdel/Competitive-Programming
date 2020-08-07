import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int res1 = 0;
		while(st.hasMoreTokens())
			res1+=Integer.parseInt(st.nextToken());
		res1 = (int)Math.ceil(res1/(1.0*5));
		int res2 = 0;
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens())
			res2+=Integer.parseInt(st.nextToken());
		res2 = (int)Math.ceil(res2/(1.0*10));
		out.println(((res1+res2)<=Integer.parseInt(br.readLine())?"YES":"NO"));
		out.flush();
		out.close();
	}
}