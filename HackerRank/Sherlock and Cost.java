import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class zizo{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            int[] B = new int[n];
            for(int i = 0; i < n; i++)
                B[i] = sc.nextInt();
            int[][] sol = new int[n][2];
            for(int i = 1; i < n; i++) {
                sol[i][0] = B[i-1] - 1 + sol[i-1][1];
                sol[i][1] = Math.max(sol[i-1][0] + B[i] - 1, sol[i-1][1] + Math.abs(B[i] - B[i-1]));        
            }
            out.println(Math.max(sol[n-1][0], sol[n-1][1]));
        }
        
        out.flush();
        out.close();
    }
    
    static class Scanner 
    {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s){    br = new BufferedReader(new InputStreamReader(s));}

        public String next() throws IOException 
        {
            while (st == null || !st.hasMoreTokens()) 
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {return Integer.parseInt(next());}
        
        public long nextLong() throws IOException {return Long.parseLong(next());}

        public String nextLine() throws IOException {return br.readLine();}
        
        public double nextDouble() throws IOException{return Double.parseDouble(next());}
            
        public boolean ready() throws IOException {return br.ready();}


    }
}
