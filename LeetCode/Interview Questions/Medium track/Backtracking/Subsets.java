class Solution {
    static List<List<Integer>> list;
    static int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        list = new ArrayList();
        Solution.nums = nums;
        bruteForce(0, new ArrayList<Integer>());
        return list;
    }
    
    public static void bruteForce(int idx, List<Integer> l) {
        if(idx == nums.length) {
            list.add(l);
            return;
        }
        bruteForce(idx + 1, l);
        List<Integer> t = new ArrayList(l);
        t.add(nums[idx]);
        bruteForce(idx + 1, t);
    }
}