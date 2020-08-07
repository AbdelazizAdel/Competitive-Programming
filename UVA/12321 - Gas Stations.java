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
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			if(L == 0 && G == 0)
				break;
			Interval[] intervals = new Interval[G];
			for(int i = 0; i < G; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				intervals[i] = new Interval(x-r, x+r);
			}
			Arrays.sort(intervals);
			int edge = 0, ans = 0, j = 0;
			while(j < G) {
				int max = edge;
				while(j < G && intervals[j].start <= edge)
					max = Math.max(max, intervals[j++].end);
				if(max == edge)
					break;
				ans++;
				edge = max;
				if(edge >= L)
					break;		
			}
			out.println(edge>=L?G-ans:-1);
		}
		out.flush();
		out.close();
	}
	
	
	static class Interval implements Comparable<Interval>{
		int start, end;
		
		public Interval(int a, int b) {
			start = a;
			end = b;
		}

		@Override
		public int compareTo(Interval i) {
			// TODO Auto-generated method stub
			return start - i.start;
		}
	}
}