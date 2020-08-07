import java.util.*;
import java.io.*;
public class zizo4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true){
			int n = Integer.parseInt(br.readLine());
			if(n==0)
				break;
			PriorityQueue<Integer> pq = new PriorityQueue();
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens())
				pq.add(Integer.parseInt(st.nextToken()));
			int cost = 0;
			while(pq.size()>=2) {
				int sum = pq.poll()+pq.poll();
				cost+=sum;
				pq.add(sum);
			}
			out.println(cost);
		}
		out.flush();
		out.close();
	}
}
