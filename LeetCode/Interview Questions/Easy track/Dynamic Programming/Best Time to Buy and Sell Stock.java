class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2)
            return 0;
        int min = prices[0], ans = 0;
        for(int i = 1; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            if(prices[i] > min)
                ans = Math.max(ans, prices[i] - min);
        }
        return ans;
    }
}