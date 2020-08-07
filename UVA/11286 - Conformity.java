import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true) {
			int n = Integer.parseInt(br.readLine());
			if(n==0)
				break;
			TreeMap<CourseCollection, Integer> tree = new TreeMap<CourseCollection, Integer>();
			TreeSet<Integer> sort = new TreeSet<Integer>();
			while(n-->0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				while(st.hasMoreTokens())
					sort.add(Integer.parseInt(st.nextToken()));
				CourseCollection x = new CourseCollection(sort.pollFirst(), sort.pollFirst(), sort.pollFirst(), sort.pollFirst(), sort.pollFirst());
				//out.println(x);
				if(tree.containsKey(x)) {
					int v = tree.get(x)+1;
					tree.put(x, v);
				}
				else
					tree.put(x,1);
			}
			int max = 0;
			for(int a: tree.values()) {
				//out.println(a);
				max = a>max?a:max;
			}
				
			int sum = 0;
			for(int a: tree.values())
				if(a==max)
					sum+=max;
			out.println(sum);
		}
		out.flush();
		out.close();
	}
	
	static class CourseCollection implements Comparable<CourseCollection>{
		int a,b,c,d,e;
		
		public CourseCollection(int v, int w, int x, int y, int z) {
			a = v;
			b = w;
			c = x;
			d = y;
			e = z;
		}

		@Override
		public int compareTo(CourseCollection x) {
			if(a!=x.a)
				return a-x.a;
			else if(b!=x.b)
				return b-x.b;
			else if(c!=x.c)
				return c-x.c;
			else if(d!=x.d)
				return d-x.d;
			else if(e!=x.e)
				return e-x.e;
			else
				return 0;
		}
		public String toString() {
			return a+" "+b+" "+c+" "+d+" "+e;
		}
		public boolean equals(CourseCollection o){return this.compareTo(o) == 0;}
	}
}
	
	
