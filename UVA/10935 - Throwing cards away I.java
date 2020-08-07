import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringBuilder s = new StringBuilder("");
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0)
				break;
			Queue<Integer> queue = new LinkedList<Integer>();
			for(int i = 0; i<n; i++)
				queue.add(i+1);
			 s.append("Discarded cards: ");
			 if(queue.size()==1) {
				 s.deleteCharAt(s.length()-1);
				 s.append("\n");
			 }
				 
			while(queue.size()>=2) {
				s.append(queue.remove()+((queue.size()==1)?"\n":", "));
				queue.add(queue.remove());
			}
			s.append("Remaining card: "+queue.remove());
			s.append("\n");
		}
		out.print(s);
		out.flush();
		out.close();
	}
		
}
	
	
