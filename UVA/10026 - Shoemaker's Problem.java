import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class zizo6 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		br.readLine();
		while(t-->0) {
			int N = Integer.parseInt(br.readLine());
			Job[] jobs = new Job[N];
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				Job j = new Job(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i+1);
				jobs[i] = j;
			}
			Arrays.sort(jobs);
			for(int i = 0; i < N; i++)
				out.print(jobs[i].idx+(i==N-1?"":" "));
			out.println();
			if(t>0) {
				out.println();
				br.readLine();
			}
			
		}
		out.flush();
		out.close();
	}
	
	
	static class Job implements Comparable<Job>{
		int t, s, idx;
		
		public Job(int a, int b, int c) {
			t = a;
			s = b;
			idx = c;
		}

		@Override
		public int compareTo(Job j) {
			// TODO Auto-generated method stub
			if(t*j.s != j.t*s)
				return t*j.s - j.t*s;
			return idx - j.idx;
		}
		
		
	}
}