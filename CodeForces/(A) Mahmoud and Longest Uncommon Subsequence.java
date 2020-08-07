import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String a = br.readLine();
		String b = br.readLine();
		int res = -1;
		if(a.length()!=b.length())
			res = (int)Math.max(a.length(), b.length());
		else if(!a.equals(b))
			res = a.length();
		out.println(res);
		out.flush();
		out.close();
	}
	
}