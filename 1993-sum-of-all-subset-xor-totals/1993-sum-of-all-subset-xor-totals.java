class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;  
        int sum = 0;  
        for (int i = 0; i < (1 << n); i++) {  
            int xorSum = 0;  
            for (int j = 0; j < n; j++) {  
                if ((i & (1 << j)) != 0) {  
                    xorSum ^= nums[j];  
                }  
            }  
            sum += xorSum;  
        }  
        return sum;  
    }
}