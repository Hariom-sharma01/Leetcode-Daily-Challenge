class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int l = -1, h = queries.length+1;
        while(h - l > 1){
            int m = h+l>>1;
            if(solve(nums, queries, m)){
                h = m;
            }else{
                l = m;
            }
        }
        return h > queries.length ? -1 : h;
    }

    public boolean solve(int[] nums, int[][] queries, int h) {
        int n = nums.length;
        long[] count = new long[n + 1];
        for(int i = 0;i < h;i++){
            int[] q = queries[i];
            count[q[0]] += q[2];
            count[q[1] + 1] -= q[2];
        }
        for (int i = 0; i < n; i++) {
            count[i + 1] += count[i];
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > count[i]) return false;
        }
        return true;
    }
}