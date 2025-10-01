class Solution {
    public int numWaterBottles(int n, int ch) {
        int ans=n;
        while(n>=ch){
            ans+=n/ch;
            n=(n%ch)+(n/ch);
        }
        return ans;
        
    }
}