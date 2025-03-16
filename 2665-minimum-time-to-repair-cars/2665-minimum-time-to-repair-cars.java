class Solution {
    public long repairCars(int[] ranks, int cars) {
        long l = 0;  
        long r = (long)ranks[0] * cars * cars; 
        long ans = r;  

        while (l <= r) {  
            long mid = l + (r - l) / 2;  
            long rc = 0;  

            for (int i : ranks) {  
                rc += (long) Math.floor(Math.sqrt((double) mid / i));  
            }  

            if (rc >= cars) {  
                ans = mid;  
                r = mid - 1;  
            } else {  
                l = mid + 1;  
            }  
        }  

        return ans;
    }
}