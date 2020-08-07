import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int count = 0;
		for(int i = 1; i<=n; i++)
			if(x%i == 0 && x/i >= 1 && x/i <=n) 
				count++;
		out.println(count);
		out.flush();
	}
}