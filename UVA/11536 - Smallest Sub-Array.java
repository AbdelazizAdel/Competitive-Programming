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
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			if(K > N) {
				out.println("Case "+t+": "+"sequence nai");
				continue;
			}
			int[] values = new int[N];
			for(int i = 0; i < N; i++) {
				if(i<=2)
					values[i] = i+1;
				else
					values[i] = (values[i-1]+values[i-2]+values[i-3])%M + 1;
			}
			int freq[] = new int[K+1], c = 0, min = N+1;
			for(int i = 0, j = 0; j < N; j++) {
				if(values[j]<=K && ++freq[values[j]] == 1 )
					c++;
				while(i<=j && c == K) {
					min = Math.min(min, j-i+1);
					if(values[i]<=K && --freq[values[i]] == 0 )
						c--;
					i++;
				}
			}
			out.println("Case "+t+": "+(min==N+1?"sequence nai":min));
		}
		out.flush();
		out.close();
		br.close();
	}
}