class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0, ans = 0;
        HashMap<Character, Integer> map = new HashMap();
        for(int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            len++;
            if(!map.containsKey(c)){
                map.put(c, 1);
                ans = Math.max(len, ans);
            }
            else {
                map.put(c, map.get(c) + 1);
                if(map.get(c) == 1)
                    ans = Math.max(len, ans);
                else {
                    while(i < j) {
                        char c2 = s.charAt(i);
                        map.put(c2, map.get(c2) - 1);
                        len--;
                        i++;
                        if(map.get(c2) == 1)
                            break;
                    }
                }
            }
        }
        return ans;
    }
}