class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<List<String>>();
        String[] clone = new String[strs.length];
        for(int i = 0; i < strs.length; i++){
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            clone[i] = new String(arr); 
        }
            
        TreeMap<String, List<String>> map = new TreeMap();
        for(int i = 0; i < clone.length; i++) {
            if(!map.containsKey(clone[i])){
                List<String> list = new ArrayList();
                list.add(strs[i]);
                map.put(clone[i], list);
            }
            else {
                List<String> list = map.get(clone[i]);
                list.add(strs[i]);
                map.put(clone[i], list);
            }
        }
        for(List<String> list : map.values())
            ans.add(list);
        return ans;
    }
}