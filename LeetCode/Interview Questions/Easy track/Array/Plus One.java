class Solution {
    public int[] plusOne(int[] digits) {
        if(nines(digits)){
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            return ans;
        }
        else {
            for(int i = digits.length - 1; i >= 0; i--){
                if(digits[i] < 9){
                    digits[i] = digits[i] + 1;
                    return digits;
                }
                digits[i] = 0;
            }
        }
        return new int[]{};
    }
    
    public static boolean nines(int[] arr){
        for(int i = 0; i < arr.length; i++)
            if(arr[i] != 9)
                return false;
        return true;
    }
}