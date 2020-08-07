import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		int i;
		for(i = n+1; i<=9012; i++) {
			int a = i%10, b = (i/10)%10, c = (i/100)%10, d = i/1000;
			if(a!=b & a!=c & a!=d & b!=c & b!=d & c!=d)
				break;
		}
		out.println(i);
		out.flush();
	}
}