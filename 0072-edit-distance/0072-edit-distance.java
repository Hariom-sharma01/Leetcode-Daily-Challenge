class Solution {
    static int[][] dp;
    public int minDistance(String s, String t) {
        dp=new int[s.length()+1][t.length()+1];
        return min_ops(s,t,0,0);
    }
    public static int min_ops(String s,String t,int i,int j){
        if(s.length()==i) return t.length()-j;
        if(j==t.length())return s.length()-i;
        if(dp[i][j]!=0)return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            dp[i][j]=min_ops(s,t,i+1,j+1);
        }
        else{
            int D=min_ops(s,t,i+1,j);
            int R=min_ops(s,t,i+1,j+1);
            int I=min_ops(s,t,i,j+1);
            dp[i][j]=Math.min(R,Math.min(D,I))+1;
        }
        return dp[i][j];
    }
}