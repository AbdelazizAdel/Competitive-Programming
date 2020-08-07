import java.util.*;
import java.io.*;
public class zizo2 {
	static int n;
	static int[] flow_rate, cost;
	
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		n = Integer.parseInt(br.readLine());
		flow_rate = new int[n];
		cost = new int[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			flow_rate[i] = Integer.parseInt(st.nextToken());
			cost[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		for(int i = 1; i <= m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			long ans = bruteforce(0, (1.0*v)/t);
			if(ans == Integer.MAX_VALUE)
				out.printf("Case %d: IMPOSSIBLE\n", i);
			else
				out.printf("Case %d: %d\n", i, ans);
		}
		out.flush();
		out.close();
	}
	
	public static long bruteforce(int idx, double needed_vol) {
		if(idx == n)
			return needed_vol<=0?0:Integer.MAX_VALUE;
		if(needed_vol<=0)
			return 0;
		long take = cost[idx] + bruteforce(idx+1, needed_vol - flow_rate[idx]);
		long leave = bruteforce(idx+1, needed_vol);
		return Math.min(take, leave);
	}
}