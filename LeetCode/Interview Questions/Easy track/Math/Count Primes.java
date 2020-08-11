class Solution {
    public int countPrimes(int n) {
        int ans = 0;
        for(int i = 2; i < n; i++)
            if(isPrime(i))
                ans++;
        return ans;
    }
    
    public static boolean isPrime(int n) {
        int limit = (int) Math.sqrt(n);
        for(int i = 2; i <= limit; i++)
            if(n % i == 0)
                return false;
        return true;
    }
}