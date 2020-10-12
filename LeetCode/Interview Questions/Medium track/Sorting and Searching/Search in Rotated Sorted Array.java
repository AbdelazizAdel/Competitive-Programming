class Solution {
    public int search(int[] nums, int target) {
        int start = findPeakElement(nums) + 1;
        if(target >= nums[0])
            return binarySearch(nums, 0, start - 1, target);
        else
            return binarySearch(nums, start, nums.length - 1, target);
    }
    
    public int binarySearch(int[] nums, int s, int e, int target) {
        while(s <= e) {
            int mid = s + e >> 1;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] > target)
                e = mid - 1;
            else
                s = mid + 1;
        }
        return -1;
    }
    
     public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;
        while(low < high) {
            int mid = low + high >> 1;
            if(nums[mid] < nums[low])
                high = mid - 1;
            else if(nums[mid] > nums[mid + 1])
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}