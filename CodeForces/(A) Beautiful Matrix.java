import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int row = 0, column = 0;
		boolean found = false;
		for(row = 0; row<5; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(column = 0; column<5; column++)
				if(Integer.parseInt(st.nextToken())==1) {
					found = true;
					break;
				}
			if(found)
				break;
		}
		out.println(Math.abs(row-2)+Math.abs(column-2));
		out.flush();
	}
}