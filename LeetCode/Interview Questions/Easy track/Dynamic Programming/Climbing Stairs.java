class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        for(int i = 0; i <= n; i++){
            if(i > 0)
                memo[i]+=memo[i - 1];
            if(i > 1)
                memo[i]+=memo[i - 2];
        }
        return memo[n];
    }
}