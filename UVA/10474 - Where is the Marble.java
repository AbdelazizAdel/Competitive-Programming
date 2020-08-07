import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class zizo6 {
	static int[] marbels;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int num = 1;
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			if(N == 0 && Q == 0)
				break;
			marbels = new int[N];
			for(int i = 0; i < N; i++)
				marbels[i] = Integer.parseInt(br.readLine());
			Arrays.sort(marbels);
			out.printf("CASE# %d:\n", num++);
			for(int i = 0; i < Q; i++) {
				int q = Integer.parseInt(br.readLine());
				int ans = BS(q);
				if(ans == 0)
					out.printf("%d not found\n", q);
				else
					out.printf("%d found at %d\n", q, ans);
			}
		}
		out.flush();
		out.close();
	}
	
	public static int BS(int v) {
		int low = 0, high = marbels.length-1, ans = -1;
		
		while(low <= high) {
			int mid = (low + high)>>1;
			if(marbels[mid] == v) {
				ans = mid;
				high = mid-1;
			}
			else if (marbels[mid] < v)
				low = mid+1;
			else
				high = mid-1;
		}
		return ans+1;
	}
	
	
 
}