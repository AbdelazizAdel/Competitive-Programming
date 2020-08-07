import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class zizo6 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		int num = 1;
		while(t-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			if(N == 0) {
				out.println("Case "+(num++)+": "+D);
			}
			int[] pos = new int[N+3];
			pos[0] = 0;pos[N+1] = D;
			char[] type = new char[N+3];
			boolean[] used = new boolean[N+3];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i < N+1; i++) {
				StringTokenizer st2 = new StringTokenizer(st.nextToken(),"-");
				type[i] = st2.nextToken().charAt(0);
				pos[i] = Integer.parseInt(st2.nextToken());
			}
			int max = 0;
			for(int i = 0; i < N+1; i++) {
				used[i] = true;
				if(type[i+1] == 'S')
					max = Math.max(max, pos[i+2] - pos[i++]);
				else
					max = Math.max(max, pos[i+1] - pos[i]);
			}
			for(int i = N+1; i > 0; i--) {
				if(type[i-1] == 'S' && !used[i-1])
					max = Math.max(max, pos[i] - pos[i-1]);
				else if(type[i-1] == 'S' && used[i-1]) 
					max = Math.max(max, pos[i--] - pos[i-1]);
				else
					max = Math.max(max, pos[i] - pos[i-1]);
			}
			out.println("Case "+(num++)+": "+max);
		}
		out.flush();
		out.close();
	}
}