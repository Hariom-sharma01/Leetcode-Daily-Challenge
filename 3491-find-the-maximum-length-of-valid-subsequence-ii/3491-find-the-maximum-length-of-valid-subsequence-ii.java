class Solution {
    public static int maximumLength(int[] nums, int k) {
        int len= nums.length;
        int[][] arr = new int[len][k];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < k; j++) {
                arr[i][j] = 1;
            }
        }
        int ans= 1;
        for(int i=1;i<len;i++){
            for(int j=0;j<i;j++){
                int temp=(nums[i]+nums[j])%k;
                arr[i][temp]=Math.max(arr[i][temp],arr[j][temp]+1);
                ans=Math.max(ans,arr[i][temp]);
            }
        }
        return ans;
    }
}
