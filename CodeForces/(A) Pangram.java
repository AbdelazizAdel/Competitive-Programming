import java.io.*;
public class zizo2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int x = Integer.parseInt(br.readLine());
		String y = br.readLine();
		y = y.toLowerCase();
		boolean res = true;
		for(int i = 0;i<26;i++) {
			char a = (char)((int)('a')+i);
			res &= y.contains(a+"");
		}
		out.println(res?"YES":"NO");
		out.flush();
	}
}