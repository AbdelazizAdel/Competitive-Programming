/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

import java.util.*;

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long low = 1, high = n, ans = -1;
        while(low <= high) {
            long mid = low + high >> 1l;
            if(isBadVersion((int) mid)) {
                ans = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return (int) ans;
    }
    
}