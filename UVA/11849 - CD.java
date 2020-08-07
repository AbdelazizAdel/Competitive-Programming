import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			if(n==0 && m==0)
				break;
			HashSet<Integer> hsN = new HashSet();
			HashSet<Integer> hsM = new HashSet();
			int[] arr1 = new int[n];
			for(int i = 0; i<n ; i++) {
				int x = Integer.parseInt(br.readLine());
				hsN.add(x);
				arr1[i] = x;
			}
			for(int i = 0 ; i<m; i++) {
				int x = Integer.parseInt(br.readLine());
				hsM.add(x);
			}
			int sum = 0;
			for(int i = 0; i<n ; i++)
				if(hsM.contains(arr1[i]))
					sum++;
			out.println(sum);
		}
		out.flush();
		out.close();
	}
}
	
	
