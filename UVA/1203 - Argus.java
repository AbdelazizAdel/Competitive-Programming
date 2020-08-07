import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		PriorityQueue<Query> pq = new PriorityQueue();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			if(st.nextToken().equals("#"))
				break;
			pq.add(new Query(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		int n = Integer.parseInt(br.readLine());
		while(n-->0) {
			Query x = pq.remove();
			out.println(x.Q_num);
			x.Period+=x.inc;
			pq.add(x);
		}
		out.flush();
		out.close();
	}
	
	
	
	static class Query implements Comparable<Query>{
		int Q_num, Period, inc;
		
		public Query(int a, int b) {
			Q_num = a;
			Period = b;
			inc = b;
		}

		@Override
		public int compareTo(Query x) {
			// TODO Auto-generated method stub
			int p = Period - x.Period;
			int num = Q_num - x.Q_num;
			return (p==0)?num:p;
		}
	}
}
	
	
