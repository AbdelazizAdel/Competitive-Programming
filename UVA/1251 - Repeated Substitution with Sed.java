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
	static substitution[] substitutions;
	static String delta;
	static int min = (int)1e9;
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0)
				break;
			substitutions = new substitution[n];
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				substitution x = new substitution(st.nextToken(), st.nextToken());
				substitutions[i] = x;
			}
			String gamma = br.readLine();
			delta = br.readLine();
			bruteforce(gamma, 0);
			out.println(min == (int)1e9?-1:min);
			min = (int)1e9;
		}
		br.close();
		out.flush();
		out.close();
	}
	
	public static void bruteforce(String s_sofar, int count) {
		if(s_sofar.length() == delta.length()) {
			if(s_sofar.equals(delta))
				min = Math.min(min, count);
			return;
		}
		for(int i = 0; i < substitutions.length; i++)
			if(s_sofar.contains(substitutions[i].alpha))
				if((s_sofar.length() + substitutions[i].beta.length() - substitutions[i].alpha.length()) <= delta.length())
					bruteforce(s_sofar.replaceAll(substitutions[i].alpha, substitutions[i].beta), count+1);
	}
	
	static class substitution{
		String alpha, beta;
		
		public substitution(String a, String b) {
			alpha = a;
			beta = b;
		}
	}
}