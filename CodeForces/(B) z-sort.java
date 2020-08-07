import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);
		int[] ans = new int[n];
		int k = 0;
		for(int i = 0; i<n/2; i++) {
			ans[k++] = arr[i];
			ans[k++] = arr[n-1-i];
		}
		ans[n-1] = n%2==0?ans[n-1]:arr[n/2];
		for(int i = 0; i<n ; i++)
			out.print(ans[i]+((i==n-1)?"":" "));
		out.flush();
		out.close();
	}
}
	
	
