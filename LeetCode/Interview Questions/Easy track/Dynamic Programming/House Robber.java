class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(0, nums, memo);
    }
    
    public static int dp(int idx, int[] nums, int[] memo) {
        if(idx >= nums.length)
            return 0;
        if(memo[idx] != -1)
            return memo[idx];
        return memo[idx] = Math.max(nums[idx] + dp(idx + 2, nums, memo), dp(idx + 1, nums, memo));
    }
}