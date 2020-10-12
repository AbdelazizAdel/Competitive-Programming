class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n == 0)
            return s;
        int[] d1 = new int[n], d2 = new int[n];
        for(int i = 0, l = 0, r = -1; i < n; i++) {
            int k = r < i ? 1 : Math.min(d1[l + r - i], r - i + 1);
            while(i - k >= 0 && i + k < n && s.charAt(i - k) == s.charAt(i + k))
                k++;
            d1[i] = k--;
            if(i + k > r) {
                l = i - k;
                r = i + k;
            }
        }
        for(int i = 0, l = 0, r = -1; i < n; i++) {
            int k = i > r ? 0 : Math.min(d2[l + r - i], r - i + 1);
            while(i - k - 1 >= 0 && i + k < n && s.charAt(i - k - 1) == s.charAt(i + k))
                k++;
            d2[i] = k--;
            if(i + k > r) {
                l = i - k - 1;
                r = i + k;
            }
        }
        int max_odd = 0, max_even = 0;
        for(int i = 1; i < n; i++) {
            if(d1[i] > d1[max_odd])
                max_odd = i;
            if(d2[i] > d2[max_even])
                max_even = i;
        }
        if(d1[max_odd] > d2[max_even])
            return s.substring(max_odd - d1[max_odd] + 1, max_odd + d1[max_odd]);
        else
            return s.substring(max_even - d2[max_even], max_even + d2[max_even]);
    }
}