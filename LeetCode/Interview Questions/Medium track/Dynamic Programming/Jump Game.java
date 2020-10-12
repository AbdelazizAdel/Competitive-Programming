class Solution {
    public boolean canJump(int[] nums) {
        int can_reach = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            can_reach = Math.max(can_reach, i + nums[i]);
            if(can_reach == i)
                return false;
            if(can_reach >= nums.length - 1)
                return true;
        }
        return can_reach >= nums.length - 1;
    }
}