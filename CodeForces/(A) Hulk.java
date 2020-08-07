import java.io.*;
public class zizo2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		String res = "";
		boolean hate = true;
		while(n>=1) {
			if(n==1) 
				res += hate?"I hate it":"I love it";
			else
				res += hate?"I hate that ":"I love that ";
			hate = !hate;
			n--;
		}
		out.println(res);
		out.flush();
	}
}