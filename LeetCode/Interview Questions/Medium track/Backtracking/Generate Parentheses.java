class Solution {
    static List<String> list;
    static int n;
    public List<String> generateParenthesis(int n) {
        list = new ArrayList();
        Solution.n = n;
        if(n == 0)
            return list;
        bruteForce(0, 0, "");
        return list;
    }
    
    public static void bruteForce(int open, int closed, String s) {
        if(open == n && closed == n){
            list.add(s);
            return;
        }
        if(open < n)
            bruteForce(open + 1, closed, s + "(");
        if(open > closed)
            bruteForce(open, closed + 1, s + ")");
    }
}