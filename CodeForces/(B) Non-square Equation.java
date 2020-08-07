import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		long n = Long.parseLong(br.readLine());
		long ans  = (long)1e10;
		for(int i = 1; i <= 81 ; i++) {
			double sol = root(i, n);
			if(sol%2==0 && sol>0) {
				int sum = sumOfDigits((int)(sol)/2);
				if(sum == i) 
					ans = Math.min(ans, (int)(sol)/2);
			}
		}
		out.println(ans==(long)1e10?-1:ans);
		out.flush();
		out.close();
	}
	
	public static int sumOfDigits(int x) {
		int ans = 0;
		while(x>0) {
			ans+=x%10;
			x = x/10;
		}
		return ans;
	}
	public static double root(int s, long n) {

		long x = (long)(Math.sqrt(s*s + 4 * n));
		if(x*x == s*s + 4 * n)
			return -1*s + Math.sqrt(s*s + 4*n);
		return -1;
	}
}
	
	
