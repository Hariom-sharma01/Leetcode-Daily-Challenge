class Solution {
    public int minCapability(int[] nums, int k) {
        int l = 1;  
        int r = 1000000000;  
        int ans = r;  

        while (l <= r) {  
            int mid = l + (r - l) / 2;  
            if (canRob(nums, k, mid)) {  
                ans = mid;  
                r = mid - 1;  
            } else {  
                l = mid + 1;  
            }  
        }  

        return ans;  
    }
    private boolean canRob(int[] nums, int k, int mid) {  
        int c = 0;  
        for (int i = 0; i < nums.length; i++) {  
            if (nums[i] <= mid) {  
                c++;  
                i++;  
            }  
        }  
        return c >= k;  
    } 
}