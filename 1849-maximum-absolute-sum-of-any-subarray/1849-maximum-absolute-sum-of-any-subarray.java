class Solution {
    public int maxAbsoluteSum(int[] nums) {
         return Math.max(findMaxSum(nums),Math.abs(findMinSum(nums)));
    }
    public int findMaxSum(int[] nums){
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum < 0) {
                currentSum = 0; 
            }
        }
        return maxSum;
    }
    public int findMinSum(int[] nums){
        int minSum = Integer.MAX_VALUE;
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;
            minSum = Math.min(minSum, currentSum);
            if (currentSum > 0) {  
                currentSum = 0;
            }
        }
        return minSum;
    }
}