class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        return KthSmallestPossible(nums1, nums2, k);
    }

    public long KthSmallestPossible(int[] nums1, int[] nums2, long k) {
        long lo = -1_000_000_000_000_000_000L; // Lower bound for product
        long hi = 1_000_000_000_000_000_000L;  // Upper bound for product
        long ans = 0;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (countProduct(nums1, nums2, mid) >= k) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }

    public long countProduct(int[] nums1, int[] nums2, long target) {
        long count = 0;

        for (int a : nums1) {
            if (a == 0) {
                if (target >= 0) count += nums2.length;
            } else if (a > 0) {
                int low = 0, high = nums2.length - 1, best = -1;
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    if ((long) a * nums2[mid] <= target) {
                        best = mid;
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                count += best + 1;
            } else {
                int low = 0, high = nums2.length - 1, best = nums2.length;
                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    if ((long) a * nums2[mid] <= target) {
                        best = mid;
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                count += nums2.length - best;
            }
        }

        return count;
    }
}