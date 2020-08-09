import java.util.*;

class Solution {
    public int reverse(int x) {
        char[] arr = (x + "").substring(x < 0 ? 1 : 0).toCharArray();
        for(int i = 0; i < arr.length / 2; i++){
            char temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        try {
            int ans = Integer.parseInt((x < 0 ? "-" : "") + new String(arr));
            return ans;
        }
        catch (Exception e) {
            return 0;
        }
    }
}