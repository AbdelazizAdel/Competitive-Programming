import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class zizo6 {
	static int vessels[], n, m;
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		while(br.ready()) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			vessels = new int[n];
			for(int i = 0; i < n; i++)
				vessels[i] = Integer.parseInt(st.nextToken());
			out.println(BS());
		}
		
		out.flush();
		out.close();
	}
	
	public static int BS() {
		int low = 0, high = (int)1e9, ans = 0;
		while(low <= high) {
			int mid = (low + high)>>1;
			if(can(mid)) {
				ans = mid;
				high = mid - 1;
			}
			else
				low = mid+1;
		}
		return ans;
	}
	
	public static boolean can(int max) {
		int c = 0, n_ves = 0;
		for(int i = 0, j = 0; i < m; i++) {
			while(j < n && c+vessels[j] <= max) {
				c+=vessels[j++];
				n_ves++;
			}
			c = 0;
		}
		return n_ves==n?true:false;
	}
	 
}