class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            for(int j = i + 1; j < nums.length - 1; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int idx = BS(j + 1, (nums[i] + nums[j]) * -1, nums);
                if(idx != - 1){
                    List<Integer> l = new ArrayList<Integer>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[idx]);
                    ans.add(l);
                }
            }
        }
        return ans;
    }
    
    public static int BS(int low, int val, int[] nums) {
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + high >> 1;
            if(nums[mid] == val)
                return mid;
            else if(nums[mid] < val)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}