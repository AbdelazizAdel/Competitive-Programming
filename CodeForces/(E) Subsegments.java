import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class zizo7 {
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		long startTime = System.nanoTime();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) 
			arr[i] = Integer.parseInt(br.readLine());
		Deque<pair> dq = new LinkedList<pair>();
		TreeMap<pair, Integer> t = new TreeMap();
		TreeSet<Integer> ts = new TreeSet(Collections.reverseOrder());
		for(int i = 0; i < n; i++) {
			pair p = new pair(arr[i], i);
			if(!dq.isEmpty() && dq.getFirst().idx <= i-k) {
				int x = t.get(dq.getFirst())-1;
				if(x==0) {
					t.remove(dq.getFirst());
					ts.remove(dq.getFirst().v);
				}
				else {
					t.put(dq.getFirst(), x);
					if(x==1)
						ts.add(dq.getFirst().v);
				}	
				dq.removeFirst();
			}
			dq.addLast(p);
			if(!t.containsKey(p)) {
				t.put(p, 1);
				ts.add(p.v);
			}
			else {
				int x = t.get(p)+1;
				t.put(p, x);
				ts.remove(p.v);
			}
			if(i>=k-1) {
				out.println(ts.isEmpty()?"Nothing":ts.first());		
			}
				
		}

		out.flush();
		out.close();
		br.close();
	}
	
	static class pair implements Comparable<pair>{
		int v, idx;
		
		public pair(int a, int b) {
			v = a;
			idx = b;
		}

		@Override
		public int compareTo(pair p) {
			// TODO Auto-generated method stub
			return p.v-v;
		}
	
	}
}