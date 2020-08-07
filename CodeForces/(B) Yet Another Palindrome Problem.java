import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			if(n<3) {
				out.println("NO");
				continue;
			}
			int[] arr = new int[n];
			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			boolean flag = false;
			for(int i = 0; i<= n-3; i++) {
				for(int j = i+2; j < n; j++) {
					if(arr[i] == arr[j]) {
						flag = true;
						break;
					}
				if(flag)
					break;
				}
			}
			out.println(flag?"YES":"NO");
		}
		out.flush();
		out.close();
	}
}
