import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		boolean first = true;
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[n+1];
			int count = 0;
			for(int j = 0; j<n; j++) {
				int x = Integer.parseInt(st.nextToken());
				if(arr[x]==0) {
					count++;
					arr[x] =1;
				}
			}
			if(count == n) {
				out.print(first?n:n-1);
				out.print((i==n-1)?"":" ");
				first = false;
			}
			else {
				out.print(count-1);
				out.print((i==n-1)?"":" ");
			}
		}
		out.println();
		out.flush();
	}
}