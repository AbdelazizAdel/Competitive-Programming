import java.util.*;
    
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> h = new HashMap();
        for(int i = 0; i < nums1.length; i++)
            if(h.containsKey(nums1[i]))
                h.put(nums1[i], h.get(nums1[i]) + 1);
            else
                h.put(nums1[i], 1);
        
        ArrayList<Integer> arr = new ArrayList();
        for(int num : nums2)
            if(h.containsKey(num)){
                arr.add(num);
                int count = h.get(num);
                if(count == 1)
                    h.remove(num);
                else
                    h.put(num, count - 1);
            }
        
        int[] ans = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++)
            ans[i] = arr.get(i);
        return ans;
    }
}