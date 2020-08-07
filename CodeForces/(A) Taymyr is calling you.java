import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int z = Integer.parseInt(st.nextToken());
		boolean[] arr = new boolean[z+1];
		int res = 0;
		for(int i = 1 ; i<=z/n; i++)
			arr[n*i] = true;
		for(int i = 1; i<=z/m; i++)
			if(arr[m*i])
				res++;
		out.println(res);
		out.flush();
		out.close();
	}
	
}