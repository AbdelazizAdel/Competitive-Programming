import java.util.*;
import java.io.*;
public class zizo2 {
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int d = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			int[] xs = new int[n];
			int[] ys = new int[n];
			int[] num_rats = new int[n];
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				xs[i] = Integer.parseInt(st.nextToken());
				ys[i] = Integer.parseInt(st.nextToken());
				num_rats[i] = Integer.parseInt(st.nextToken());
			}
			int[][] city = new int[1025][1025];
			int max = -1;
			for(int i = 0; i < n; i++) {
				int x_start = Math.max(0, xs[i]-d);
				int x_end = Math.min(1024, xs[i]+d);
				int y_start = Math.max(0, ys[i]-d);
				int y_end = Math.min(1024, ys[i]+d);
				for(int j = x_start; j <= x_end; j++)
					for(int k = y_start; k <= y_end; k++) {
						city[j][k]+=num_rats[i];
						max = city[j][k]>max?city[j][k]:max;
					}
			}
			boolean x = false;
			for(int j = 0; j < 1025; j++) {
				for(int k = 0; k < 1025; k++)
					if(city[j][k] == max) {
						out.printf("%d %d %d\n", j, k, max);
						x = true;
						break;
					}
				if(x)
					break;
			}
		}
		out.flush();
		out.close();
	}
}