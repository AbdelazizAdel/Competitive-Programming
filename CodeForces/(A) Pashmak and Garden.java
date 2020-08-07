import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		if(x1 == x2) {
			int dy = (int)(Math.abs(y2-y1));
			out.println((x1+dy)+" "+y1+" "+(x2+dy)+" "+y2);
		}
		else if(y1 == y2) {
			int dx = (int)(Math.abs(x2-x1));
			out.println(x1+" "+(y1+dx)+" "+x2+" "+(y2+dx));
		}
		else {
			if(Math.abs(x2-x1)!=Math.abs(y2-y1))
				out.println(-1);
			else {
				int d = (int)Math.abs(x2-x1);
				float slope = (float)((y2-y1)*1.0/(x2-x1));
				if(slope>0)
					if(x1<x2)
						out.println(x1+" "+(y1+d)+" "+x2+" "+(y2-d));
					else
						out.println(x2+" "+(y2+d)+" "+x1+" "+(y1-d));
				else
					if(x1<x2)	
						out.println(x1+" "+(y1-d)+" "+x2+" "+(y2+d));
					else
						out.println(x2+" "+(y2-d)+" "+x1+" "+(y1+d));
			}
		
		}
		out.flush();
		out.close();
	}
	
}