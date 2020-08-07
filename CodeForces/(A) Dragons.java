import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class zizo5{
	public static void main (String[] args) throws InterruptedException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		Dragon[] dragons = new Dragon[n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			Dragon d = new Dragon(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			dragons[i] = d;
		}
		Arrays.sort(dragons);
		boolean all = true;
		for(int i = 0; i < n; i++) {
			if(s > dragons[i].strength)
				s+=dragons[i].bonus;
			else {
				all = false;
				break;
			}
		}
		System.out.println(all?"YES":"NO");
		out.flush();
		out.close();
	}
	
	static class Dragon implements Comparable<Dragon>{
		int strength, bonus;
		
		public Dragon(int a, int b) {
			strength = a;
			bonus = b;
		}

		@Override
		public int compareTo(Dragon d) {
			// TODO Auto-generated method stub
			return this.strength - d.strength;
		}
		
	}
}