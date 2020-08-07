import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int[][] arr = new int[4][4];
		for(int i = 0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<4; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		boolean res = false;
		if(arr[0][3]==1) 
			res|= arr[0][0]==1 || arr[0][1]==1 || arr[0][2]==1 || arr[2][1]==1 || arr[1][0]==1 || arr[3][2]==1;
		if(arr[1][3]==1) 
			res|= arr[1][0]==1 || arr[1][1]==1 || arr[1][2]==1 || arr[3][1]==1 || arr[2][0]==1 || arr[0][2]==1;
		if(arr[2][3]==1) 
			res|= arr[2][0]==1 || arr[2][1]==1 || arr[2][2]==1 || arr[0][1]==1 || arr[3][0]==1 || arr[1][2]==1;
		if(arr[3][3]==1) 
			res|= arr[3][0]==1 || arr[3][1]==1 || arr[3][2]==1 || arr[1][1]==1 || arr[0][0]==1 || arr[2][2]==1;
		out.println(res==true?"YES":"NO");
		out.flush();
		out.close();
		}
		
	}
	
