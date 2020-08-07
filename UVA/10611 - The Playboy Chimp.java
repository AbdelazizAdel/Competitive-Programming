import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
 
public class zizo6 {
	static int[] heights;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		heights = new int[N];
		for(int i = 0; i < N; i++)
			heights[i] = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] queries = new int[Q]; 
		for(int i = 0; i < Q; i++)
			queries[i] = Integer.parseInt(st.nextToken());
		for(int q: queries) {
			int ans1 = TS(q);
			int ans2 = ST(q);
			out.println((ans1==-1?"X":ans1)+" "+(ans2==-1?"X":ans2));
		}
		out.flush();
		out.close();
	}
	
	public static int ST(int v) {
		int low = 0, high = heights.length-1, ans = -1;
		while(low <= high) {
			int mid = (low + high)>>1;
			if(heights[mid] > v) {
				ans = heights[mid];
				high = mid-1;
			}
			else
				low = mid+1;
		}
		return ans;
	}
	public static int TS(int v) {
		int low = 0, high = heights.length-1, ans = -1;
		while(low <= high) {
			int mid = (low + high)>>1;
			if(heights[mid] < v) {
				ans = heights[mid];
				low = mid+1;
			}
			else
				high = mid-1;
		}
		return ans;
	}
 
}