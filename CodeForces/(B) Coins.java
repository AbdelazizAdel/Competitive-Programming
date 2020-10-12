import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
	static ArrayList<Integer>[] adjList;
	static int[] status;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		adjList = new ArrayList[3];
		status = new int[3];
		for(int i = 0; i < 3; i++)
			adjList[i] = new ArrayList();
		for(int i = 0; i < 3; i++) {
			char[] arr = sc.nextLine().toCharArray();
			if(arr[1] == '>')
				adjList[arr[0] - 'A'].add(arr[2] - 'A');
			else
				adjList[arr[2] - 'A'].add(arr[0] - 'A');
		}
		if(isCyclic(0))
			System.out.println("Impossible");
		else {
			int[] indegree = new int[3];
			for(ArrayList<Integer> u : adjList)
				for(int v : u)
					indegree[v]++;
			char[] ans = new char[3];
			for(int i = 0; i < 3; i++)
				ans[indegree[i]] = (char)('A' + i);
			for(int i = 2; i >= 0; i--)
				System.out.print(ans[i]);
		}
		out.flush();
		out.close();
	}
	
	public static boolean isCyclic(int u) {
		status[u] = 1;
		for(int v : adjList[u]) {
			if(status[v] == 0) {
				if(isCyclic(v))
					return true;
			}
			else if(status[v] == 1)
				return true;
		}
		status[u] = 2;
		return false;
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