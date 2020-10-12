class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int num: nums) {
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        Pair[] pairs = new Pair[map.size()];
        int idx = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
            pairs[idx++] = new Pair(entry.getKey(), entry.getValue());
        quickSelect(pairs, 0, pairs.length - 1, k);
        int[] ans = new int[k];
        idx = 0;
        for(int i = pairs.length - k; i < pairs.length; i++)
            ans[idx++] = pairs[i].v;
        return ans;
    }
    
    public void quickSelect(Pair[] arr, int start, int end, int k) {
        if(start >= end)
            return;
        int pivot_idx = partition(arr, start, end);
        if(pivot_idx < arr.length - k)
            quickSelect(arr, pivot_idx + 1, end, k);
        else
            quickSelect(arr, start, pivot_idx - 1, k);
    }
    
    public int partition(Pair[] arr, int start, int end) {
        Pair pivot = arr[end];
        int store_index = start - 1;
        for(int i = start; i < end; i++)
            if(arr[i].f <= pivot.f)
                swap(arr, i, ++store_index);
        swap(arr, end, ++store_index);
        return store_index;
    }
    
    public void swap(Pair[] arr, int i, int j) {
        Pair temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    static class Pair {
        int v, f;
        
        public Pair(int a, int b) {
            v = a;
            f = b;
        }
    }
}