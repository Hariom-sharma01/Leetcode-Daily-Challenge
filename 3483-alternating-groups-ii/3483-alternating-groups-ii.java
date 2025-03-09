class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
         int n = colors.length;
         int c= 1;
         int ans= 0;
        for (int i = 0; i < n + k - 2; ++i) {
            if (colors[i % n] != colors[(i + 1) % n]) {
                c++;
            } else {
                c= 1;
            }
            ans+= (c>= k) ? 1 : 0;
        }
        
        return ans;
    }
}
