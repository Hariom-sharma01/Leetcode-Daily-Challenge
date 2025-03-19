class Solution {
    public int minOperations(int[] nums) {
         int n= nums.length;
        int ans= 0;

        int i=0;
        while(i< n - 2) {
            if (nums[i] == 0) {
                nums[i] = 1;
                nums[i + 1] = 1 - nums[i + 1];
                nums[i + 2] = 1 - nums[i + 2];
                ans++;
            }
            i++;
        }
        i=n-2;

        while(i< n) {
            if (nums[i] == 0) {
                return -1;
            }
            i++;
        }

        return ans;
    }
}