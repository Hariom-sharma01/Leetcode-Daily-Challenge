class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        Arrays.sort(satisfaction);

        int dp[][] = new int[n+1][n+1];
        for(int i=n-1;i>=0;i--){
        
        for(int t = i;t>=0;t--){
                int pick = satisfaction[i]*(t+1)+dp[i+1][t+1];
                int notpick = 0+dp[i+1][t];

                dp[i][t] = Math.max(pick,notpick);

        }
        
        }
        

        return dp[0][0];
    }
}