import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class zizo5 {
	static dom_tile tiles[], end;
	static boolean flag;
	static int n;
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true) {
			n = Integer.parseInt(br.readLine());
			if(n == 0)
				break;
			int m = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			dom_tile start = new dom_tile(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			st = new StringTokenizer(br.readLine());
			end = new dom_tile(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			tiles = new dom_tile[m];
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				dom_tile x = new dom_tile(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				tiles[i] = x;
			}
			bruteforce(start.r, 0, 0);
			out.println(flag?"YES":"NO");
			flag = false;
		}
		out.flush();
		out.close();
	}
	
	public static void bruteforce(int prev_r, int count, int taken) {
		if(count == n) {
			if(end.l == prev_r)
				flag = true;
		}
		else
			for(int i = 0; i < tiles.length; i++)
				if((taken & (1<<i)) == 0 && prev_r == tiles[i].l)
					bruteforce(tiles[i].r, count+1, taken | (1<<i));
				else if((taken & (1<<i)) == 0 && prev_r == tiles[i].r)
					bruteforce(tiles[i].l, count+1, taken | (1<<i));		
	}
	
	static class dom_tile{
		int l, r;
		
		public dom_tile(int a, int b) {
			l = a;
			r = b;
		}
	}
}