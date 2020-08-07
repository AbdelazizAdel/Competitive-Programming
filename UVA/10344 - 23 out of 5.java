import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class zizo5 {
	static int[] operands;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			operands = new int[5];
			boolean zeros = false;
			for(int i = 0; i < 5; i++) {
				operands[i] = Integer.parseInt(st.nextToken());
				if(operands[i] != 0)
					zeros = true;
			}
			if(!zeros)
				break;
			backtrack(0, 0, 0);
			if(flag)
				out.println("Possible");
			else
				out.println("Impossible");
			flag = false;
		}
		out.flush();
		out.close();
	}

	public static void backtrack(int cur, int sum, int taken) {
		if(cur == 5) {
			if(sum == 23)
				flag = true;
		}	
		else {
			for(int i = 0; i < 5; i++) {
				if((taken & (1<<i)) == 0) {
					if(cur>0) {
						backtrack(cur + 1, sum + operands[i], taken | (1<<i));
						backtrack(cur + 1, sum - operands[i], taken | (1<<i));
						backtrack(cur + 1, sum * operands[i], taken | (1<<i));
					}
					else
						backtrack(cur + 1, sum + operands[i], taken | (1<<i));
				}
			}
		}
	}
	
	
}