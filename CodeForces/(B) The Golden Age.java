import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class zizo5 {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long l = Long.parseLong(st.nextToken());
        long r = Long.parseLong(st.nextToken());
        int a = (int) Math.floor(Math.log10(r)/Math.log10(x));
        int b = (int) Math.floor(Math.log10(r)/Math.log10(y));
        ArrayList<Long> arr = new ArrayList<>();

        for(int i = 0; i <= a; i++)
            for(int j = 0; j <= b; j++) {
                long tmp = (long)(pow(x, i) + pow(y, j));
                if(tmp > (long)1e18)
                    break;
                if(tmp >= l && tmp <=r)
                    if(!arr.contains(tmp))
                        arr.add(tmp);
            }
        Collections.sort(arr);
        if(arr.size() == 0)
            out.println(r-l+1);
        else {
            long max = arr.get(0) - l;
            for(int i = 0; i < arr.size(); i++)
                if(i == arr.size()-1) {
                    max = Math.max(max, r-arr.get(arr.size()-1));
                    if(arr.size()-1 != 0)
                        max = Math.max(max, arr.get(i) - arr.get(i-1)-1);
                }
                else if(i == 0)
                    continue;
                else
                    max = Math.max(max, arr.get(i) - arr.get(i-1)-1);
            out.println(max);
        }
        out.flush();
        out.close();
    }
    public static boolean contains(long[] arr, long e) {
        for(int i = 0; i < arr.length; i++)
            if(arr[i] == e)
                return true;
        return false;
    }

    public static long pow(long base, long power){
        if(power == 0)
            return 1;
        return base*pow(base, power-1);
    }
}