class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, (int)1e9);
        memo[0] = 0;
        for(int i = 0; i <= amount; i++)
            for(int j = 0; j < coins.length; j++)
                if(i - coins[j] >= 0)
                    memo[i] = Math.min(memo[i], memo[i - coins[j]] + 1);
        return memo[amount] == (int)1e9 ? -1 : memo[amount];
    }
    
}