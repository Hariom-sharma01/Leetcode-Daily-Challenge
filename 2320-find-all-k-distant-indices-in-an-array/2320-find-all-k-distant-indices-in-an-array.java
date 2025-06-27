class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int l = 0, r = 0;

        while (l < n && r < n) {
            if (nums[r] != key) {
                r++;
            } else if (l < r - k) {
                l++;
            } else if (l <= r + k) {
                ans.add(l++);
            } else {
                r++;
            }
        }

        return ans;
    }
}