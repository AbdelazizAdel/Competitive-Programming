import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class zizo6 {
	static int row, col;
	static TreeSet<String> sols;
	static boolean[] rows;
	public static void main(String[] argss) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String x = "SOLN       COLUMN\n" + 
				" #      1 2 3 4 5 6 7 8\n\n";
		rows = new boolean[8];
		sols = new TreeSet<String>();
		while(n-->0) {
			sb.append(x);
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			bruteforce(new int[8], 0);
			int i = 1;
			while(!sols.isEmpty())
				sb.append((i<10?" ":"")+(i++)+"      "+sols.pollFirst()+"\n");
			if(n != 0)
				sb.append("\n");
			rows = new boolean[8];
		}
		System.out.print(sb.toString());
	}
	
	public static void bruteforce(int[] arr, int idx) {
		if(idx == rows.length) {
			if(arr[col-1] == row)
				sols.add(arr_rep(arr));
			return;
		}
		for(int i = 0; i < rows.length; i++) {
			if(!rows[i] && checkDiagonals(arr, i, idx)) {
				rows[i] = true;
				arr[idx] = i+1;
				bruteforce(arr, idx+1);
				rows[i] = false;
			}
		}
	}
	
	public static String arr_rep(int[] arr) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < arr.length; i++)
			sb.append(arr[i] + (i == arr.length-1?"":" "));
		return sb.toString();
	}
	public static boolean checkDiagonals(int[] arr, int row, int col) {
		for(int i = 0; i < col; i++)
			if(Math.abs(arr[i] - row - 1) == Math.abs(i - col))
				return false;
		return true;
	}
}