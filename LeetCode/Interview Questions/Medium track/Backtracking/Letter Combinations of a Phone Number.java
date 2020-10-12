class Solution {
    static List<String> list;
    static String map[], digits;
    public List<String> letterCombinations(String digits) {
        list = new ArrayList();
        map = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Solution.digits = digits;
        if(digits.length() == 0)
            return list;
        bruteForce(0, "");
        return list;
    }
    
    public static void bruteForce(int idx, String s) {
        if(idx == digits.length()) {
            list.add(s);
            return;
        }
        String chars = map[Integer.parseInt(digits.charAt(idx) + "") - 2];
        for(int j = 0; j < chars.length(); j++)
            bruteForce(idx + 1, s + chars.charAt(j));
        }
}