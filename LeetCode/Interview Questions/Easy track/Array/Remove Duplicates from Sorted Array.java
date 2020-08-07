class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2)
            return nums.length;
        int i = 0, pos = 0;
        while(i < nums.length - 1){
            while(i < nums.length - 1 && nums[i] == nums[i + 1])
                i++;
            if(i == nums.length - 1)
                break;
            nums[pos++] = nums[i++];
        }
        nums[pos++] = nums[nums.length - 1];
        return pos;
    }
}