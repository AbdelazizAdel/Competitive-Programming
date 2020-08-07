import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String x = br.readLine();
		boolean[] arr = new boolean[26];
		for(int i = 0; i<x.length(); i++) {
			int pos = (int)(x.charAt(i))-97;
			arr[pos] = true;
		}
		int sum = 0;
		for(int i = 0; i<arr.length; i++)
			if(arr[i]==true)
				sum++;	
		out.println(sum%2==0?"CHAT WITH HER!":"IGNORE HIM!");
		out.flush();
		out.close();
		}
	}
	
