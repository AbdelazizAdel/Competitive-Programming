import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class zizo6 {
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		HashSet<Character> h = new HashSet<Character>();
		int n = Integer.parseInt(br.readLine());
		char[] flats = br.readLine().toCharArray();
		char max = 'a';
		for(int i = 0; i < n; i++) {
			max =  (char) Math.max(max, flats[i]);
			h.add(flats[i]);
		}
		int f[] = new int[max+1], ans = n+1, c = 0, num = h.size();
		for(int i = 0, j = 0; j < n; j++) {
			if(++f[flats[j]] == 1)
				c++;
			while(i<=j && c==num) {
				ans = Math.min(ans, j-i+1);
				if(--f[flats[i++]] == 0)
					c--;
			}
		}
		out.println(ans);
		out.flush();
		out.close();
		br.close();
	}
}