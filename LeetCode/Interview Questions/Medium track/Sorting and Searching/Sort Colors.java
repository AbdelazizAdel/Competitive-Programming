class Solution {
    public void sortColors(int[] nums) {
        int a = -1, b = -1, c = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                nums[++a] = 0;
                if(b != - 1)
                    nums[++b] = 1;
                if(c != -1)
                    nums[++c] = 2;
            }
            else if(nums[i] == 1) {
                if(b == -1) 
                    nums[b = a + 1] = 1;
                else
                    nums[++b] = 1;
                if(c != -1)
                    nums[++c] = 2; 
            }
            else {
                if(c == -1) {
                    if(b != -1)
                        c = b + 1;
                    else if(a != -1)
                        c = a + 1;
                    else
                        c++;
                }
                else
                    c++;
            }
        }
    }
}