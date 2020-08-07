import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int i = 0;
		while(st.hasMoreTokens()) {
			long x = Long.parseLong(st.nextToken());
			arr[i++] = x;
		}
		long sum = 0;
		for(long x: arr)
			sum+=x;
		if(sum%2 == 0)
			out.println(sum);
		else {
			Arrays.sort(arr);
			for(long x: arr)
				if(x%2!=0) {
					sum-=x;
					break;
				}
			out.println(sum);
		}
		out.flush();
	}
}