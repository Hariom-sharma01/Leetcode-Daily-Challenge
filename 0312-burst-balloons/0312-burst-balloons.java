class Solution {
    public int maxCoins(int[] nums) {
        int[] a = new int[nums.length+2];
        a[0] = a[a.length-1] = 1;
        for(int i=1;  i<a.length-1 ; i++){
            a[i] =nums[i-1];
        }
        int[][] dp = new int[a.length][a.length];
        for(int[] e:dp){
            Arrays.fill(e,-1);
        }
        return maximumCoins(a,0,a.length-1,dp);
        
    }
    public static int maximumCoins(int[] a,int i,int j,int[][] dp){
        if(i+1==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ans = Integer.MIN_VALUE;
        for(int k = i+1 ; k<j ; k++ ){
            int left = maximumCoins(a,i,k,dp);
            int right = maximumCoins(a,k,j,dp);
            int self = a[i]*a[k]*a[j];
            ans = Math.max(ans,left+right+self);
        }
        return dp[i][j] = ans;
    }
}