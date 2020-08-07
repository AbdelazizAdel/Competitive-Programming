import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class zizo7 {
	public static void main(String[] atgs) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i <= T; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++)
				arr[j] = Integer.parseInt(st.nextToken());
			int ans = 0, cur_weight = 0;
			for(int j = 0; j < n; j++)
				if(cur_weight + arr[j] <= q) {
					ans++;
					cur_weight+=arr[j];
				}
			out.println("Case "+i+": "+(ans>p?p:ans));
		}
		out.flush();
		out.close();
	}
}
