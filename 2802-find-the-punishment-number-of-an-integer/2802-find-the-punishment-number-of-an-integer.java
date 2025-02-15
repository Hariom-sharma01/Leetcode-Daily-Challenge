class Solution {
    public int punishmentNumber(int n) {
        int ans = 0;
        for(int i=1; i <= n; i++) {
            int sq = i * i;
            if (valid(String.valueOf(sq), 0, i)) {
                ans += sq;
            }
        }
        return ans;
    }
    public boolean valid(String s,int ind,int t){
        if (ind == s.length()) {
            return t == 0; 
        }

        int num = 0;
        for (int j=ind; j<s.length(); j++) {
            num = num * 10 + (s.charAt(j) - '0'); 
            if (num > t) break; 
            if (valid(s, j + 1, t - num)) {
                return true;
            }
        }
        return false;
    }
}