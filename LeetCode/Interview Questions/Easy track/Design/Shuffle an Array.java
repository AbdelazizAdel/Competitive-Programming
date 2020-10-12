class Solution {
    int[] arr, temp; 
    public Solution(int[] nums) {
        arr = new int[nums.length];
        temp = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            arr[i] = nums[i];
            temp[i] = nums[i];
        }
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        for(int i = 0; i < temp.length; i++)
            arr[i] = temp[i];
        return arr;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random rand = new Random();
        for(int i = arr.length - 1; i > 0; i--){
            int idx = rand.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }
        return arr;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */