import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		Thread.sleep(5000);
		while(br.ready()) {
			Stack<Integer> stack = new Stack();
			Queue<Integer> queue = new LinkedList<Integer>();
			PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
			int n = Integer.parseInt(br.readLine());
			boolean f1 = true;
			boolean f2 = true;
			boolean f3 = true;
			while(n-->0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				if(x==1) {
					stack.push(y);
					queue.add(y);
					pq.add(y);
				}
				else {
					int a = 0, b = 0, c = 0;
					if(!stack.isEmpty())
						a = stack.pop();
					else
						f1 = false;
					if(!queue.isEmpty())
						b = queue.remove();
					else
						f2 = false;
					if(!pq.isEmpty())
						c = pq.remove();
					else
						f1 = false;
					if(a!=y)
						f1 = false;
					if(b!=y)
						f2 = false;
					if(c!=y)
						f3 = false;
				}
			}
			if(!(f1 || f2 || f3))
				out.println("impossible");
			else if(f1 && f2 && f3)
				out.println("not sure");
			else
				if(!(f1^f2^f3))
					out.println("not sure");
				else {
					if(f1)
						out.println("stack");
					else if(f2)
						out.println("queue");
					else
						out.println("priority queue");
				}
		}
		out.flush();
		out.close();
	}
}
	
	
