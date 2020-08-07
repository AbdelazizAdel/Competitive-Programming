import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int count = 1;
		long sum = k;
		while((sum%10)!=0 && (sum%10)!=r) {
			sum+=k;
			count++;
		}
		out.println(count);
		out.flush();
	}
}