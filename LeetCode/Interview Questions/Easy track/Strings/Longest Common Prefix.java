class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        String ans = "";
        for(int i = 0; i < strs[0].length(); i++)
            if(allSame(i, strs))
                ans+=strs[0].charAt(i);
            else
                break;
        return ans;
    }
    
    public static boolean allSame(int idx, String[] arr) {
        char c = arr[0].charAt(idx);
        for(int i = 1; i < arr.length; i++)
            if(idx > arr[i].length() - 1 || arr[i].charAt(idx) != c)
                return false;
        return true;
    }
}