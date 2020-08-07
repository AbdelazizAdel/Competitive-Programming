import java.util.*;
import java.io.*;
public class zizo4 {
	static int[] nums;
	static int t, n;
	static TreeSet<String> ts;
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			if(n == 0)
				break;
			nums = new int[n];
			for(int i = 0; i < n; i++)
				nums[i] = Integer.parseInt(st.nextToken());
			StringBuilder sb = new StringBuilder("Sums of "+t+":\n");
			ts = new TreeSet(Collections.reverseOrder());
			backtrack("", 0, 0);
			if(ts.size()==0)
				sb.append("NONE\n");
			while(ts.size()>0) {
				sb.append(ts.pollFirst().replace(" ", "+"));
				sb.deleteCharAt(sb.length()-1);
				sb.append("\n");
			}
			out.print(sb);		
		}
		out.flush();
		out.close();
		}
		
	public static void backtrack(String a, int idx, int sum) {
		if(sum == t) {
			ts.add(a);
			return;
		}
		for(int i = idx; i < n; i++) 
			if(sum + nums[i] <= t)
				backtrack(a+""+nums[i]+" ", i+1, sum + nums[i]);
	}
	
	
	
}
	

