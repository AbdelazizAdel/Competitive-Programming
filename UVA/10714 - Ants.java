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
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] pos = new int[n];
			for(int i = 0; i < n; i++)
				pos[i] = Integer.parseInt(st.nextToken());
			int min = 0, max = 0;
			for(int i = 0; i < n; i++) {
				min = Math.max(min, Math.min(pos[i], l-pos[i]));
				max = Math.max(max, Math.max(pos[i], l-pos[i]));
			}
			out.println(min+" "+max);
		}
		out.flush();
		out.close();
	}
}