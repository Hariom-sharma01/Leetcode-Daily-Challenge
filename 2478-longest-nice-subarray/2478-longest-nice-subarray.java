class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;  
        int l= 0;  
        int xor = 0;  
        int ans = 0;  

        for (int r = 0; r < n; r++) {  
            while ((xor & nums[r]) != 0) {  
                xor ^= nums[l];  
                l++;  
            }  
            xor ^= nums[r];  
            ans = Math.max(ans, r - l + 1);  
        }  

        return ans;
    }
    // public boolean isNice(int[] nums, int start, int end) {  
    //     for (int i = start; i <= end; i++) {  
    //         for (int j = i + 1; j <= end; j++) {  
    //             if ((nums[i] & nums[j]) != 0) {  
    //                 return false;  
    //             }  
    //         }  
    //     }  
    //     return true;  
    // }  
}