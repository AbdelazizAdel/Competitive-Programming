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
			int[][] arr = new int[n][n];
			for(int i = 0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0 ; j<n; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			int[] num_rows = num_rows(arr);
			int[] num_columns = num_columns(arr);
			if(num_rows[0] == n && num_columns[0] == n)
				out.println("OK");
			else if(num_rows[0] == n-1 && num_columns[0] == n-1)
				out.println("Change bit ("+num_rows[1]+","+num_columns[1]+")");
			else
				out.println("Corrupt");
		}
		out.flush();
		out.close();
		}
		public static int[] num_rows(int[][] arr) {
			int num[] = new int[2];
			for(int i = 0; i<arr.length; i++) {
				int sum = 0;
				for(int j = 0; j<arr.length; j++)
					if(arr[i][j]==1)
						sum++;
				if(sum%2==0)
					num[0]++;
				else
					num[1] = i+1;
			}
			return num;
		}
		
		public static int[] num_columns(int[][] arr) {
			int[] num = new int[2];
			for(int i = 0; i<arr.length; i++) {
				int sum = 0;
				for(int j = 0; j<arr.length; j++)
					if(arr[j][i]==1)
						sum++;
				if(sum%2==0)
					num[0]++;
				else
					num[1] = i+1;
			}
			return num;
		}
	
	}
	
