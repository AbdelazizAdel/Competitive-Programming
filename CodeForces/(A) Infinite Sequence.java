import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		if(a==b)
			out.println("YES");
		else {
			if(c==0)
				out.println("NO");
			else if(c>0)
				out.println(b-a>0?((b-a)%c==0?"YES":"NO"):"NO");
			else
				out.println(b-a<0?((b-a)%c==0?"YES":"NO"):"NO");
		}
		out.flush();
		out.close();
		}
		
	}
	
