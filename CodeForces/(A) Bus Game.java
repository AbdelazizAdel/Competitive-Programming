import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		boolean ciel = true;
		while(true) {
			if(ciel) {
				if(x>=2) {
					x-=2;
					if(y>=2)
						y-=2;
					else {
						out.println("Hanako");
						break;
					}	
				}
				else if(x==1) {
					x-=1;
					if(y>=12)
						y-=12;
					else {
						out.println("Hanako");
						break;
					}
						
				}
				else {
					if(y>=22)
						y-=22;
					else {
						out.println("Hanako");
						break;
					}
						
				}
			}
			else {
				if(y>=22)
					y-=22;
				else if(y>=12) {
					y-=12;
					if(x>=1)
						x-=1;
					else {
						out.println("Ciel");
						break;
					}
						
				}
				else {
					if(y>=2) {
						y-=2;
						if(x>=2)
							x-=2;
						else {
							out.println("Ciel");
							break;
						}	
					}
					else {
						out.println("Ciel");
						break;
					}
						
				}		
			}
			ciel = !ciel;
		}
		out.flush();
		out.close();
	}
	
}