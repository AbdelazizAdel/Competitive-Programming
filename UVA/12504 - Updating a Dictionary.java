import java.util.*;
import java.io.*;
public class zizo5 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int N = Integer.parseInt(br.readLine());
		while(N-->0){
			String a = br.readLine();
			String b = br.readLine();
			String[] oldArr = a.substring(1, a.length()-1).split("[:,]");
			String[] newArr = b.substring(1, b.length()-1).split("[:,]");
			TreeMap<String, String> oldT = new TreeMap();
			TreeMap<String, String> newT = new TreeMap();
			for(int i = 0; i<oldArr.length-1; i+=2)
				oldT.put(oldArr[i], oldArr[i+1]);
			for(int i = 0; i<newArr.length-1; i+=2)
				newT.put(newArr[i], newArr[i+1]);
			StringBuilder additional = new StringBuilder("+");
			StringBuilder missing = new StringBuilder("-");
			StringBuilder changed = new StringBuilder("*");
			for(Map.Entry<String, String> e : oldT.entrySet())
				if(!newT.containsKey(e.getKey()))
					missing.append(e.getKey()+",");
				else if(newT.containsKey(e.getKey()) && (!newT.get(e.getKey()).equals(e.getValue())))
					changed.append(e.getKey()+",");
			for(String s : newT.keySet())
				if(!oldT.containsKey(s))
					additional.append(s+",");
			additional.deleteCharAt(additional.length()-1);
			missing.deleteCharAt(missing.length()-1);
			changed.deleteCharAt(changed.length()-1);
			boolean flag = true;
			if(additional.length()!=0) {
				out.println(additional.toString());
				flag = false;
			}
			if(missing.length()!=0) {
				out.println(missing.toString());
				flag = false;
			}
			if(changed.length()!=0) {
				out.println(changed.toString());
				flag = false;
			}
			if(flag)
				out.println("No changes");
			out.println();
		}
		out.flush();
		out.close();
	}
}
