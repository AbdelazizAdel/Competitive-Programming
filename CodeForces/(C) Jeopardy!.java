import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class zizo5{
	public static void main (String[] args) throws InterruptedException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] prices = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++)
			prices[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] auctionQs = new int[m];
		for(int i = 0; i < m; i++)
			auctionQs[i] = prices[Integer.parseInt(st.nextToken())-1];
		Arrays.sort(auctionQs);
		long ans = 0;
		for(int i = 0; i < n; i++) {
			if(i<m)
				ans-=auctionQs[i];
			ans+=prices[i];
		}
		for(int i = m-1; i >= 0; i--)
			ans+=Math.max(ans, auctionQs[i]);
		System.out.println(ans);
	}
}