class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{binarySearch(nums, target, true), binarySearch(nums, target, false)};
    }
    
    public int binarySearch(int[] arr, int val, boolean lower) {
        int low = 0, high = arr.length - 1, ans = -1;
        while(low <= high) {
            int mid = low + high >> 1;
            if(arr[mid] == val) {
                ans = mid;
                if(lower)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            else if(arr[mid] > val)
                high = mid -1;
            else
                low = mid + 1;
        }
        return ans;
    }
}