import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int x = Integer.parseInt(br.readLine());
		int num = 0;
		for(int i = 0; i<32; i++) 
			if((x&(1<<i))!=0)
				num++;
		out.println(num);
		out.flush();
		out.close();
	}
	
}
	
	
