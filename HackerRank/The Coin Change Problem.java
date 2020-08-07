import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    static long memo[][], coins[];
	static int n;
    /*
     * Complete the 'getWays' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. LONG_INTEGER_ARRAY c
     */

    public static long getWays(int n, List<Long> c) {
        // Write your code here
        Result.n = n;
        int len = c.size();
        memo = new long[len][n+1];
        for(long[] a: memo)
            Arrays.fill(a, -1);
        coins = new long[c.size()];
        Iterator<Long> itr = c.iterator();
        for(int i = 0; i < len; i++)
            coins[i] = itr.next();
        return dp(0, 0);
        }

        public static long dp(int idx, long sum) {
        if(sum == n)
            return 1;
        if(idx == coins.length || sum > n)
            return 0;
        if(memo[idx][(int)sum] != -1)
            return memo[idx][(int)sum];
        return memo[idx][(int)sum] = dp(idx, sum+coins[idx]) + dp(idx+1, sum);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Long> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = Result.getWays(n, c);

        bufferedWriter.write(String.valueOf(ways));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
