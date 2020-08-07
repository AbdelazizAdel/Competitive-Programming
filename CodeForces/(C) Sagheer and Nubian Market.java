import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class zizo6 {
	static Pair[] p;
	static int n, S, r;
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		p = new Pair[n];
		for(int i = 1; i <= n; i++)
			p[i-1] = new Pair(Integer.parseInt(st.nextToken()), i);
		out.println(BS()+" "+r);
		
		out.flush();
		out.close();
	}
	
	
	public static int BS() {
		int low = 0, high = n, ans = 0;
		while(low <= high) {
			int mid = (low + high)>>1;
			if(can(mid)) {
				ans = mid;
				low = mid+1;
			}
			else
				high = mid-1;
		}
		return ans;
	}
	
	public static boolean can(int k) {
		int num = 0, total = S;
		Pair[] p2 = new Pair[n];
		for(int i = 0; i < n; i++)
			p2[i] = new Pair(p[i].v + p[i].idx*k, p[i].idx);
		Arrays.sort(p2);
		for(int i = 0; i < k ; i++)
			if(total - p2[i].v >= 0) {
				total-=p2[i].v;
				num++;
			}
			else
				break;
		if(num == k)
			r = S-total;
		return num==k?true:false;
	}
	
	
	static class Pair implements Comparable<Pair>{
		int v, idx;
		
		public Pair(int a, int b) {
			v= a;
			idx = b;
		}

		@Override
		public int compareTo(Pair p) {
			// TODO Auto-generated method stub
			return v-p.v;
		}		
	}
 
}