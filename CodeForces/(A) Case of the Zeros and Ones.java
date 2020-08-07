import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		String x = br.readLine();
		int l = 0;
		for(int i = 0; i<x.length(); i++)
			if(x.charAt(i)=='1')
				l++;
		out.println(Math.abs(x.length()-l*2));
		out.flush();
		out.close();
		}
		
	}
	
