class Solution {
	    public static List<List<Integer>> generate(int numRows) {
	        List<List<Integer>> ans = new ArrayList<List<Integer>>();
	        for(int i = 0; i < numRows; i++) {
	            ans.add(new ArrayList<Integer>());
	            ans.get(i).add(1);
	            for(int j = 1; j < i; j++)
	                ans.get(i).add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                if(i > 0)
	                ans.get(i).add(1);
	        }
	        return ans;
	    }
	}