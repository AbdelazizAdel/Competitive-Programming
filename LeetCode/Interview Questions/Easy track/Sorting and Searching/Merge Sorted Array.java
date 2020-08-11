import java.util.*;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        TreeMap<Integer, Integer> map = new TreeMap();
        for(int i = 0; i < m; i++)
            if(!map.containsKey(nums1[i]))
                map.put(nums1[i], 1);
            else
                map.put(nums1[i], map.get(nums1[i]) + 1);
        for(int i = 0; i < n; i++)
            if(!map.containsKey(nums2[i]))
                map.put(nums2[i], 1);
            else
                map.put(nums2[i], map.get(nums2[i]) + 1);
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
            for(int i = 0; i < entry.getValue(); i++)
                nums1[count++] = entry.getKey();
                
    }
}