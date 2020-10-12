class Solution {
    public boolean increasingTriplet(int[] nums) {
        Integer f = null, s = null;
        for(int num : nums) {
            if(f == null)
                f = num;
            else if(num < f)
                f = num;
            else if(num > f && (s == null || num < s))
                s = num;
            else if(s != null && num > s)
                return true;
        }
        return false;
    }
}