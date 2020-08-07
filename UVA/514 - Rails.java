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
			while(true) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				Stack<Integer> stack = new Stack<Integer>();
				int[] arr = new int[n];
				boolean zero = false;
				for(int i = 0; i<n ;i++) {
					int x = Integer.parseInt(st.nextToken());
					if(x==0) {
						zero = true;
						break;
					}
					else
						arr[i] = x;
				}
				if(zero) {
					out.println();
					break;
				}
				int j = 1;
				boolean flag = false;
				for(int i = 0; i<n; i++) {
					if( !stack.isEmpty() && arr[i]==stack.peek())
						stack.pop();
					else {
						flag = false;
						while(j<=arr[i]) {
							stack.push(j++);
							flag = true;
						}
						if(!flag)
							break;
						else
							stack.pop();
					}		
				}
				out.println(flag?"Yes":"No");
				
			}
				
				
		}
		out.flush();
		out.close();
	}
		
}
	
	
