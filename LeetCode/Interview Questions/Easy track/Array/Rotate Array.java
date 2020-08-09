class Solution {
    public void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];
        for(int i = 0; i < arr.length; i++)
            arr[i] = nums[i];
        for(int i = 0; i < arr.length; i++)
            nums[(i + k) % nums.length] = arr[i];
    }
}