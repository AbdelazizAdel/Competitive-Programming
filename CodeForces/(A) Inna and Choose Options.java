import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		int[] columns = {6,4,3,2};
		int[] rows = {2,3,4,6};
		while(t-->0) {
			String x = br.readLine();
			boolean[] acc = new boolean[4];
			for(int i = 0; i<4; i++) {
				for(int j = 0; j<columns[i]; j++) {
					boolean zero = false;
					for(int k = j; k<x.length(); k+=columns[i]) {
						if(x.charAt(k)=='O') {
							zero = true;
							break;
						}
					}
					if(!zero) {
						acc[i] = true;
						break;
					}	
				}
			}
			StringBuilder tmp = new StringBuilder();
			int num = 0;
			for(int i = 0 ; i<4; i++) {
				if(acc[i]==true) {
					num++;
					tmp.append(rows[i]+"x"+columns[i]+" ");
				}
			}
			boolean first = false;
			for(int i = 0; i<x.length(); i++)
				if(x.charAt(i)=='X') {
					num++;
					first = true;
					break;
				}
			boolean last = true;
			for(int i = 0 ; i<x.length(); i++)	
				if(x.charAt(i)=='O') {
					last = false;
					break;
				}
			if(last)
				num++;
			if(num==0)
				out.println(num);
			else
				out.println(num+" "+(first?"1x12 ":"")+tmp+(last?"12x1":""));
		}
		out.flush();
		out.close();
	}
}