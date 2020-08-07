import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class zizo5{
	public static void main (String[] args) throws InterruptedException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		for(int j = 0; j < t; j++) {
			int n = Integer.parseInt(br.readLine());
			char[] arr = br.readLine().toCharArray();
			int ans = 0;
			for(int i = 0; i < n; i++) {
				if(arr[i] == '.') {
					ans++;
					i+=2;
				}
			}
		out.println("Case "+(j+1)+": "+ans);
		}
		out.flush();
		out.close();
	}
}