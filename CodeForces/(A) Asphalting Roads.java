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
		int n = Integer.parseInt(br.readLine());
		boolean[] rows = new boolean[n];
		boolean[] columns = new boolean[n];
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n*n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			if(!(rows[h] || columns[v])) {
				rows[h] = true;
				columns[v] = true;
				sb.append(i+" ");
			}
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb.toString());
	}
}