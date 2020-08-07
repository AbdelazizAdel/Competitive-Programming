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
		Thread.sleep(3000);
		while(br.ready()) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int lines = 1, length = 0;
			while(st.hasMoreTokens()) {
				String s = st.nextToken();
				length+=s.length()+1;
				if(length-1 > C) {
					lines++;
					length = s.length()+1;
				}
			}
			out.println((int)Math.ceil((lines*1.0)/L));
		}
		out.flush();
		out.close();
	}
	
	

}