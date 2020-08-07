import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int ta = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken());
		int tb = Integer.parseInt(st.nextToken());
		String[] arr = br.readLine().split(":");
		int start_time = (Integer.parseInt(arr[0])-5)*60 + Integer.parseInt(arr[1]);
		int end_time = start_time + ta;
		int res = 0;
		int start = 0;
		int end = start+tb;
		while(true) {
			if(start>=end_time || start>1139)
				break;
			if(start<end_time && end>start_time)
				res++;
			start+=b;
			end=start+tb;
		}
		out.println(res);
		out.flush();
		out.close();
		}
		
	}
	
