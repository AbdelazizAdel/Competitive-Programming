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
	static ArrayList<String> clockwise;
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int j = 1;
		StringBuilder sb = new StringBuilder();
		while(br.ready()) {
			clockwise = new ArrayList();
			int n = Integer.parseInt(br.readLine());
			bruteforce(new int[n], 0, true, 0);
			sb.append("Case "+(j++)+":\n");
			for(int i = 0; i < clockwise.size(); i++)
				sb.append(clockwise.get(i)+"\n");
			sb.append("\n");
		}
		sb.deleteCharAt(sb.length()-1);
		out.print(sb.toString());
		out.flush();
		out.close();
	}
	
	public static void bruteforce(int[] arr, int idx, boolean odd, int taken) {
		if(idx == 0) {
			arr[0] = 1;
			bruteforce(arr, idx+1, !odd, taken | (1<<1));
		}
		else if(idx == arr.length) {
			if(isPrime(arr[0] + arr[idx-1]))
				clockwise.add(arrayRep(arr));			
		}
		else {
			if(odd)
				for(int i = 3; i <= arr.length-1; i+=2) {
					int x = i + arr[idx - 1];
					if((taken & (1<<i)) == 0 && isPrime(x)) {
						arr[idx] = i;
						bruteforce(arr, idx+1, !odd, taken | (1<<i));
					}
				}
			else
				for(int i = 2; i <= arr.length; i+=2) {
					int x = i + arr[idx - 1];
					if((taken & (1<<i)) == 0 && isPrime(x)) {
						arr[idx] = i;
						bruteforce(arr, idx+1, !odd, taken | (1<<i));
					}
				}
		}
	}
	
	
	public static boolean isPrime(int x) {
		for(int i = 2; i <= Math.ceil(Math.sqrt(x)); i++)
			if(x%i == 0)
				return false;
		return true;
	}
	
	public static int[] anti_order(int[] arr) {
		int[] res = new int[arr.length];
		res[0] = arr[0];
		for(int i = arr.length-1; i > 0; i--)
			res[arr.length - i] = arr[i];
		return res;
	}
	public static String arrayRep(int[] arr) {
		String x = "";
		for(int i = 0; i < arr.length; i++)
			x+=arr[i] + ((i==arr.length-1)?"":" ");
		return x;
	}
}