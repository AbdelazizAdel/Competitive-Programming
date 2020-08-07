import java.io.*;
import java.util.*;
public class zizo2{
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			Stack<String> operands = new Stack();
			Stack<String> operators = new Stack();
			String x = br.readLine();
			for(int i = 0; i<x.length(); i++) {
				if(x.charAt(i)=='(')
					continue;
				else if(x.charAt(i)==')') {
					String a = operands.pop();
					String b = operands.pop();
					String c = operators.pop();
					operands.push(b+""+a+""+c);
				}
				else if(x.charAt(i)>='a' && x.charAt(i)<='z')
					operands.push(x.charAt(i)+"");
				else
					operators.push(x.charAt(i)+"");
			}
			out.println(operands.pop());
		}
		out.flush();
		out.close();
	}
		
}
	
	
