class Solution {
    public int maximumDifference(int[] nums) {
        int i = 0;
        int max = 0;
        for(int j = 1; j < nums.length; j++){
            if(j > i && nums[j] > nums[i]){
                max=Math.max(max,nums[j] - nums[i]);
            }
            else
                i = j;
        }

        return max==0?-1:max;
    }
}