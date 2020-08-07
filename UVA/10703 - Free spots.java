import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			if(w==0 && h==0 && n==0)
				break;
			int num = 0;
			rectangle[] arr = new rectangle[n];
			for(int i = 0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				int x2 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());
				arr[i] = new rectangle(x1, y1, x2, y2);
			}
			boolean flag = false;
			for(int i = 1; i<=w; i++)
				for(int j = 1; j<=h; j++) {
					for(int k = 0; k<n; k++) 
						if(in_between(i, j, arr[k].x1, arr[k].y1, arr[k].x2, arr[k].y2)) {
							flag = true;
							break;
						}
					if(!flag) 
						num++;
					flag = false;
				}
			if(num==0)
				out.println("There is no empty spots.");
			else if(num==1)
				out.println("There is one empty spot.");
			else
				out.println("There are "+num+" empty spots.");
						
			
			br.readLine();
		}
		out.flush();
		out.close();
	}
	
	
	public static boolean in_between(int x, int y, int x1, int y1, int x2, int y2) {
		return (((x>=x1 && x<=x2)||(x>=x2 && x<=x1)) && ((y>=y1 && y<=y2)||(y>=y2 && y<=y1)));
	}
	
	static class rectangle{
		int x1, y1, x2, y2;
		
		public rectangle(int a, int b, int c, int d) {
			x1 = a;
			y1 = b;
			x2 = c;
			y2 = d;
		}
	}
		
}
	
	
