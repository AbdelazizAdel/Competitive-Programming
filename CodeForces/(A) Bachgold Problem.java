import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int x = Integer.parseInt(br.readLine());
		int num = x/2;
		out.println(num);
		if(x%2==0) {
			for(int i = 0 ; i<num; i++)
				if(i!=num-1)
					out.print(2+" ");
				else
					out.print(2);
		}
		else {
			for(int i = 0; i<num; i++)
				if(i!=num-1)
					out.print(2+" ");
				else
					out.println(3);
		}
		out.flush();
		out.close();
	}
}