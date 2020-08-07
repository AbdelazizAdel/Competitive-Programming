import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class zizo6 {
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(3000);
		while(br.ready()) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for(int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			int sum = 0, ans = N+1;
			for(int i = 0, j = 0; j < N; j++) {
				sum+=arr[j];
				while(i <= j && sum>=S) {
					ans = Math.min(ans, j-i+1);
					sum-=arr[i++];
				}
			}
			out.println(ans==N+1?0:ans);
		}
		out.flush();
		out.close();
		br.close();
	}
}