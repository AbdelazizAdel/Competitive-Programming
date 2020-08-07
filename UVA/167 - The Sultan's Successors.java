import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class zizo6 {
	static int[][] chessBoard;
	static int max;
	static boolean[] rows;
	public static void main(String[] argss) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int k = Integer.parseInt(br.readLine());
		chessBoard = new int[8][8];
		while(k-->0) {
			rows = new boolean[8];
			for(int i = 0; i < 8; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 8; j++)
					chessBoard[i][j] = Integer.parseInt(st.nextToken());
			}
			bruteforce(new int[8], 0, 0);
			String ans = max+"";
			while(ans.length() < 5)
				ans = " "+ans;
			out.println(ans);
			max = 0;
		}
		out.flush();
		out.close();
	}
	
	public static void bruteforce(int[] arr, int sum, int idx) {
		if(idx == 8)
			max = sum>max?sum:max;
		else {
			for(int i = 0; i < 8; i++) {
				if(!rows[i] && checkDiagonals(arr, i, idx)){
					rows[i] = true;
					arr[idx] = i;
					bruteforce(arr, sum+chessBoard[i][idx], idx+1);
					rows[i] = false;
				}
			}
		}
	}
	public static boolean checkDiagonals(int[] a, int row, int col) {
		boolean flag = false;
		for(int i = 0; i < col; i++)
			if(Math.abs(i - col) == Math.abs(a[i] - row))
				return false;
		return true;
		
	}
}