import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			int min = 101;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				int x = Integer.parseInt(st.nextToken());
				min = min<=x?min:x;
				arr[i] = x;
			}
			boolean flag = true;
			for(int  i = 0; i < n; i++) {
				arr[i]-=min;
				if(arr[i]%2!=0) {
					flag = false;
					break;
				}
			}
			out.println(flag?"YES":"NO");	
		}
	out.flush();
	out.close();
	}
}
