import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		String res = "-1";
		if(arr[n-1] == 0)
			res = "UP";
		else if(arr[n-1]==15)
			res = "DOWN";
		else if(n==1)
			res = "-1";
		else 
			for(int i = 0; i<n-1; i++)
				if(arr[i]<arr[i+1])
					res = "UP";
				else
					res = "DOWN";
		out.println(res);
		out.flush();
		out.close();
	}
	
}