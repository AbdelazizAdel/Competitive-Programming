import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0)
				break;
			int a = 0, b = 0;
			boolean turn = true;
			for(int i = 0; i<32; i++) 
				if(((1<<i)&n)!=0) {
					if(turn)
						a|=(1<<i);
					else
						b|=(1<<i);
					turn = !turn;
				}
			out.println(a+" "+b);
		}
		out.flush();
		out.close();
		}
	}
	
