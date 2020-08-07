import java.util.*;
import java.io.*;
public class zizo4 {
	static int[] cds;
	static int N, num_tracks;
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(5000);
		while(br.ready()) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			num_tracks = Integer.parseInt(st.nextToken());
			cds = new int[num_tracks];
			for(int i = 0 ; i < num_tracks; i++)
				cds[i] = Integer.parseInt(st.nextToken());
			int max = 0;
			int perm = 0;
			for(int i = 0; i <= (1<<num_tracks)-1; i++) {
				int sum = 0;
				for(int j = 0; j < num_tracks; j++) {
					if((i & (1<<j))!=0)
						sum+=cds[j];
				}
				if(sum<=N) {
					if(sum>max) {
						max = sum;
						perm = i;
					}
				}
			}
			for(int i = 0; i < num_tracks; i++)
				if((perm & (1<<i))!=0)
					out.print(cds[i]+" ");
			out.println("sum:"+max);
		}
		out.flush();
		out.close();
	}
	
	
}

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
import java.util.*;
import java.io.*;
public class zizo2 {
	static int N, num_tracks, len, max;
	static int[] ans, tracks;
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(7000);
		while(br.ready()) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			num_tracks = Integer.parseInt(st.nextToken());
			tracks = new int[num_tracks];
			for(int i = 0; i < num_tracks; i++)
				tracks[i] = Integer.parseInt(st.nextToken());
			ans = new int[num_tracks];
			backtrack(new int[num_tracks], 0, 0, 0);
			for(int i = 0; i < len; i++)
				out.print(ans[i]+" ");
			out.println("sum:"+max);
			max = 0;
		}
		out.flush();
		out.close();
	}
	
	public static void backtrack(int[] a, int idx, int sum, int cur_track) {
		if(cur_track == num_tracks) {
			if(sum > max) {
				max = sum;
				len = idx;
				for(int i = 0; i < idx; i++)
					ans[i] = a[i];
			}
		}
		else {
			for(int i = cur_track; i < num_tracks ; i++) {
					if(sum+tracks[i] <= N) {
						a[idx] = tracks[i];
						backtrack(a, idx+1, sum+tracks[i],i+1);
					}
					else
						backtrack(a, idx, sum, i+1);
			}
		}
	}
}
