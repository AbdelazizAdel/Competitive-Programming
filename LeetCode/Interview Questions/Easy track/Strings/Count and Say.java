import java.util.*;
class Solution {
    public String countAndSay(int n) {
        String cur = "1";
        for(int i = 1; i < n; i++) {
            String s = "";
            int j = 0;
            while(j < cur.length()) {
                int freq = 0;
                char c = cur.charAt(j);
                while(j < cur.length() && cur.charAt(j) == c){
                    freq++;
                    j++;
                }
                s = s + freq + c;
            }
            cur = s;
        }
        return cur;
    }
}