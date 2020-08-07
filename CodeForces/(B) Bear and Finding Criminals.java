import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int  i = 0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int count = (arr[a-1]==0)?0:1;
		for(int i = 1; i<n; i++) {
			if((a-1-i)>=0 & (a-1+i)<n) {
				if(arr[a-1-i]==1 & arr[a-1+i]==1)
					count+=2;
			}
			else if(a-1-i>=0) {
				if(arr[a-1-i]==1)
					count++;
			}
			else if(a-1+i<n) {
				if(arr[a-1+i]==1)
					count++;
			}
			else
				break;	
		}
		out.println(count);
		out.flush();
	}
}