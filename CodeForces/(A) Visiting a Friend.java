import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		teleport[] arr = new teleport[n];
		for(int i = 0 ; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new teleport(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		boolean[] reach = new boolean[n];
		if(arr[0].x!=0)
			out.println("NO");
		else {
			reach[0] = true;
			boolean change = true, res = false;
				for(int i = 0; i<n ; i++) {
					if(reach[i]==true) {
						change  = false;
						if(m>=arr[i].x && m<=arr[i].y) {
							res = true;
							break;
						}
						for(int j = i+1; j<n; j++) {
							if(arr[j].x>=arr[i].x && arr[j].x<=arr[i].y) {
								reach[j] = true;
								change  = true;
								if(m>=arr[j].x && m<=arr[j].y) {
									res = true;
									break;
								}
							}
						}
					}
				}
				out.println(res?"YES":"NO");
			}
		out.flush();
		out.close();
		}
	
	static class teleport{
		int x;
		int y;
		
		public teleport(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}