class Solution {
    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for (int num : candies) sum += num;
        if (sum < k) return 0;
        int h=-1;
        for (int num : candies){
            if(num>h)h=num;
        }
        int l = 1, ans = 0;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            long c = 0;
            for (int i : candies) {
                c += i / mid;
                if (c >= k) break;
            }
            if (c >= k) {
                ans = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return ans;
    }
}