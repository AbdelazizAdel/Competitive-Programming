class Solution {
    static List<List<Integer>> list;
    static int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        list = new ArrayList();
        if(nums.length == 0)
            return list;
        Solution.nums = nums;
        bruteForce(new ArrayList<Integer>(), new boolean[nums.length]);
        return list;
    }
    
    public static void bruteForce(List<Integer> p, boolean[] taken) {
        if(p.size() == nums.length) {
            list.add(new ArrayList<Integer>(p));
            return;
        }
        for(int i = 0; i < nums.length; i++)
            if(!taken[i]) {
                p.add(nums[i]);
                taken[i] = true;
                bruteForce(p, taken);
                taken[i] = false;
                p.remove(p.size() - 1);
            }
    }
}