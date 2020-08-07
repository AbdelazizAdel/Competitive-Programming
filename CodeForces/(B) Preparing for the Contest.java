import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class zizo7 {
	static int[] schedule;
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = sc.nextInt(), m = sc.nextInt(), s = sc.nextInt();
		Bug[] bugs = new Bug[m];
		for(int i = 0; i < m; i++)
			bugs[i] = new Bug(sc.nextInt(), i);
		int[] levels = new int[n];
		for(int i = 0; i < n; i++)
			levels[i] = sc.nextInt();
		int[] complexities = new int[n];
		for(int i = 0; i < n; i++)
			complexities[i] = sc.nextInt();
		Student[] students = new Student[n];
		for(int i = 0; i < n; i++)
			students[i] = new Student(levels[i], complexities[i], i+1);
		schedule = new int[m];
		Arrays.sort(students, new Comparator<Student>() {

			public int compare(Student a, Student b) {
				return b.b - a.b;
			}
		});
		Arrays.sort(bugs, new Comparator<Bug>() {
			
			public int compare(Bug a, Bug b) {
				return b.a - a.a;
			}
		});
		boolean ans = binarySearch(students, bugs, s);
		if(ans) {
			out.println("YES");
			for(int i = 0; i < m; i++)
				out.print(schedule[i] + (i==m-1?"":" "));
			out.println();
		}
		else
			out.println("NO");
		
		out.flush();
		out.close();
	}
	
	public static boolean binarySearch(Student[] students, Bug[] bugs, int s) {
		int low = 0, high = bugs.length, ans = -1;
		while(low <= high) {
			int mid = low + high >> 1;
			int[] old_value = new int[bugs.length];
			for(int i = 0; i < bugs.length; i++)
				old_value[i] = schedule[i];
			if(can(students, bugs, s, mid)) {
				ans = mid;
				high = mid-1;
			}
			else {
				low = mid+1;
				schedule = old_value;
			}
		}
		return ans!=-1;
	}
	
	public static boolean can(Student[] students, Bug[] bugs, int s, int t) {
		PriorityQueue<Student> pq = new PriorityQueue<Student>(new Comparator<Student>() {

			public int compare(Student a, Student b) {
				return a.c - b.c;
			}
		});
		
		for(int i = 0, j = 0; i < bugs.length; i+=t) {
			
			while(j < students.length && students[j].b >= bugs[i].a)
				pq.add(students[j++]);
			if(pq.isEmpty())
				return false;
			Student ans = pq.poll();
			s-=ans.c;
			if(s < 0)
				return false;
			for(int k = i; k < Math.min(i+t, bugs.length); k++)
				schedule[bugs[k].idx] = ans.idx;
		}
		return true;
	}
	
	
	static class Bug{
		int a, idx;
		
		public Bug(int x, int y) {
			a = x;
			idx = y;
		}
	}
	
	static class Student{
		int b, c, idx;
		
		public Student(int x, int y, int z) {
			b = x;
			c = y;
			idx = z;
		}
	}
	
	
	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}

		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}

		public double nextDouble() throws IOException{return Double.parseDouble(next());}

		public boolean ready() throws IOException {return br.ready();}


	}
}