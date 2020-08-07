import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class zizo5{
	public static void main (String[] args) throws InterruptedException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(br.ready()) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			String t = st.nextToken();
				int j = 0, k = 0;
				while(k < s.length() && j < t.length()) {
					if(s.charAt(k) == t.charAt(j))
						k++;
					j++;
				}
				out.println(k == s.length()?"Yes":"No");
			}
		out.flush();
		out.close();
	}
}