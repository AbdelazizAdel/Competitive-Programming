class Solution {
    public int findKthLargest(int[] nums, int k) {
        quickSelect(nums, 0, nums.length - 1, k);
        return nums[nums.length - k];
    }
    
    public void quickSelect(int[] arr, int s, int e, int k) {
        if(s >= e)
            return;
        int pivot_idx = partition(arr, s, e);
        if(pivot_idx > arr.length - k)
            quickSelect(arr, s, pivot_idx - 1, k);
        else if(pivot_idx < arr.length - k)
            quickSelect(arr, pivot_idx + 1, e, k);
    }
    
    public int partition(int[] arr, int s, int e) {
        int pivot = arr[e], idx = s - 1;
        for(int i = s; i < e; i++)
            if(arr[i] <= pivot)
                swap(arr, i, ++idx);
        swap(arr, ++idx, e);
        return idx;
    }
    
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}