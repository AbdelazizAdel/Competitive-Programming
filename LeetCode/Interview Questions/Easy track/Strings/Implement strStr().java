import java.util.*;

class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;
        if(needle.length() > haystack.length())
            return -1;
        int n = haystack.length(), m = needle.length();
        long[] hash_tb = new long[n - m + 1];
        long needle_hash = 0, rolling_hash = 0, pow = (long) Math.pow(26, m - 1);
        for(int i = 0; i < m; i++){
            needle_hash+=needle.charAt(i) * pow;
            rolling_hash+=haystack.charAt(i) * pow;
            pow/=26;
        }
        hash_tb[0] = rolling_hash;
        pow = (long) Math.pow(26, m - 1);
        for(int i = 1; i < n - m + 1; i++)
            hash_tb[i] = (hash_tb[i - 1] - haystack.charAt(i - 1) * pow) * 26 + haystack.charAt(i + m - 1);
        for(int i = 0; i < n - m + 1; i++)
            if(hash_tb[i] == needle_hash && haystack.substring(i, i + m).equals(needle))
                return i;
        return -1;
    }
}