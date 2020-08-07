import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			String x = br.readLine();
			int n = x.length();
			int first = x.indexOf("R")+1;
			int last = n-x.lastIndexOf("R");
			int d = Math.max(first, last);
			int d2 = 0;
			int l = Math.max(n,x.lastIndexOf("R")+1);
			for(int i = first; i < l; i++) {
				d2++;
				if(x.charAt(i) == 'R') {
					d = Math.max(d, d2);
					d2 = 0;
				}
			}
			out.println(d);
		}
		out.flush();
		out.close();
	}
}
