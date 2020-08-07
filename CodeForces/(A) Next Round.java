import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int count = k;
		if(arr[k-1]<=0) 
			for(int i = k-1; i>=0; i--) {
				if(arr[i]>0)
					break;
				count--;
			}
		else
			for(int i = k; i<n; i++) {
				if(arr[i]==arr[k-1])
					count++;
				else
					break;
			}
		out.println(count);
		out.flush();
	}
}