class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> lis = new ArrayList();
        for(int i = 0; i < nums.length; i++) {
            int idx = binarySearch(lis, nums[i]) + 1;
            if(idx == lis.size())
                lis.add(nums[i]);
            else
                lis.set(idx, nums[i]);
        }
        return lis.size();
    }
    
    public int binarySearch(List<Integer> list, int val) {
        int low = 0, high = list.size() - 1, ans = -1;
        while(low <= high) {
            int mid = low + high >> 1;
            if(list.get(mid) < val) {
                ans = mid;
                low = mid + 1;
            }
            else
                high = mid - 1;
        }
        return ans;
    }
}