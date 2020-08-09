class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if(isValid(s.charAt(i)) && isValid(s.charAt(j)))
                if(s.charAt(i) != s.charAt(j))
                    return false;
                else {
                    i++;
                    j--;
                    continue;
                }
            if(!isValid(s.charAt(i)))
                i++;
            if(!isValid(s.charAt(j)))
                j--;
        }
        return true;
    }
    
    public static boolean isValid(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
    
}