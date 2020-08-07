import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class zizo6 {
	static String odd_values = "bcdfghjklmnpqrstvwxyz";
	static String even_values = "aeiou";
	static int count[], len, num;
	static double[] values = {12.53, 1.42, 4.68, 5.86, 13.68, 0.69, 1.01, 0.70, 6.25, 0.44, 0.00, 4.97, 3.15, 6.71, 8.68, 2.51, 0.88, 6.87, 7.98, 4.63, 3.93, 0.90, 0.02, 0.22, 0.90, 0.52};
	static double sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		while(n-->0) {
			String s = br.readLine();
			len = s.length();
			count = new int[(int)('z'+1)];
			count[s.charAt(0)] = 1;
			sum = 0;
			num = 0;
			bruteforce(values[(s.charAt(0)-'a')], 1);
			double sbc = 0;
			for(int i = 0; i < len; i++)
				sbc+=values[s.charAt(i)-'a'] * (i+1);
			double avg = sum/num;
			out.println(sbc >= avg?"above or equal":"below");
		}
		out.flush();
		out.close();
	}
	
	public static void bruteforce(double s, int pos) {
		if(pos == len) {
			sum+=s;
			num+=1;
			return;
		}
		if(pos%2 == 1) {
			for(int i = 0; i < even_values.length(); i++)
				if(count[even_values.charAt(i)]<2) {
					count[even_values.charAt(i)]++;
					bruteforce(s+values[even_values.charAt(i)-'a']*(pos+1), pos+1);
					count[even_values.charAt(i)]--;
				}		
		}
		else {
			for(int i = 0; i < odd_values.length(); i++)
				if(count[(int)odd_values.charAt(i)]<2) {
					count[(int)odd_values.charAt(i)]++;
					bruteforce(s+values[odd_values.charAt(i)-'a']*(pos+1), pos+1);
					count[(int)odd_values.charAt(i)]--;
				}
		}
					
	}
}