import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class zizo5{
	public static void main (String[] args) throws InterruptedException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		for(int k = 1; k <= t; k++){
			int n = Integer.parseInt(br.readLine());
			char[][] arr = new char[n][n];
			for(int i = 0; i < n; i++) {
				String s = br.readLine();
				for(int j = 0; j < n; j++) {
					char c = s.charAt(j);
					arr[i][j] = c;
				}
			}
			char[] arr2 = {'A', 'B', 'C', 'D', 'E'};
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(arr[i][j] != '.')
						continue;
					for(int a = 0; a < 5; a++)
						if(!contains(arr, i, j, arr2[a])) {
							arr[i][j] = arr2[a];
							break;
						}
				}
			}
			out.println("Case "+k+":");
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++)
					out.print(arr[i][j]);
				out.println();
			}
		}
		out.flush();
		out.close();
	}
	
	
	public static boolean contains(char[][] arr, int a, int b, char c) {
		if(a-1 >= 0)
			if(arr[a-1][b] == c)
				return true;
		if(a+1 < arr.length)
			if(arr[a+1][b] == c)
				return true;
		if(b-1 >= 0)
			if(arr[a][b-1] == c)
				return true;
		if(b+1 < arr.length)
			if(arr[a][b+1] == c)
				return true;
		return false;
	}
}