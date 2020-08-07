import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class zizo6 {
	static String[] floors;
	static int min = Integer.MAX_VALUE, num_ones, l;
	public static void main(String[] argss) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken())+2;
		floors  = new String[n];
		for(int i = 0; i<n; i++) {
			floors[n-1-i] = br.readLine();
			num_ones+=count_rooms(floors[n-1-i]);
		}
		bruteforce(0, 0, 0, 0, 0);
		System.out.println(min);
	}
	public static void bruteforce(int floor, int rooms, int time, int transition_cost, int pos) {
		if(rooms == num_ones) {
			min = Math.min(min, time-transition_cost);
			return;
		}
		int a = first_room(floors[floor]);
		int n = last_room(floors[floor]);
		int m = count_rooms(floors[floor]);
		if(pos == 0) {
			bruteforce(floor+1, rooms+m, time+l, l-n, l-1);
			bruteforce(floor+1, rooms+m, time+2*n+1, n+1, 0);
		}
		else {
			bruteforce(floor+1, rooms+m, time+l, a+1, 0);
			bruteforce(floor+1, rooms+m, time+2*(l-1-a)+1, l-a, l-1);	
		}
	}
	public static int last_room(String floor) {
		int res = 0;
		for(int i = 0; i < floor.length(); i++)
			if(floor.charAt(i) == '1')
				res = i;
		return res;
	}
	public static int first_room(String floor) {
		int res = floor.length()-1;
		for(int i = 0; i < floor.length(); i++)
			if(floor.charAt(i) == '1') {
				res = i;
				break;
			}		
		return res;
	}
	public static int count_rooms(String floor) {
		int res = 0;
		for(int i = 0; i < floor.length(); i++)
			if(floor.charAt(i) == '1')
				res+=1;
		return res;
	}
}