import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class zizo6 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		out.println(BS(n, k));
		
		out.flush();
		out.close();
	}
	
	public static boolean can(int n, int k, int v) {
		int ans = v, d = k;
		while(v/d > 0) {
			ans+=v/d;
			d*=k;
		}
		return ans>=n?true:false;
	}
	
	public static int BS(int n, int k) {
		int low = 1, high = n, ans = 0;
		while(low <= high) {
			int mid = (low + high)>>1;
			if(can(n, k, mid)) {
				ans = mid;
				high = mid-1;
			}
			else
				low = mid+1;
		}
		return ans;
	}
 
}