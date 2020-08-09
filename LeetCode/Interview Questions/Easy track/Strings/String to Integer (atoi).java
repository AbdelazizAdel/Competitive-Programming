class Solution {
    public int myAtoi(String str) {
        int first = 0;
        while(first < str.length() && str.charAt(first) == ' ')
            first++;
        if(first == str.length() || !isValid(str.charAt(first)))
            return 0;
        boolean sign = str.charAt(first) == '-' ? true : false;
        if(str.charAt(first) == '-' || str.charAt(first) == '+')
            first++;
        String s = "0";
        while(first < str.length() && str.charAt(first) >= '0' && str.charAt(first) <= '9')
            s+=str.charAt(first++);
        try{
            int ans = Integer.parseInt(sign ? "-" + s : s);
            return ans;
        }
        catch (Exception e) {
            return sign? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
            
    }
    
    public static boolean isValid(char c) {
        return c == '+' || c == '-' || (c >= '0' && c <= '9');
    }
}