class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long low = -1000_000_0001l;
        long high = 1000_000_0001l;
        long ans =0;

        while(low <= high){
            long mid = (low+high)/2;

            if(countProduct(nums1, nums2, mid)>=k){
                ans = mid;
                high = mid-1;
            }
            else
                low = mid+1;
        }

        return ans;
    }

    public static long countProduct(int[]nums1, int[]nums2, long dot_pro){
        long ans =0;

        for(int e1: nums1){
            int c =0;
            int low =0;
            int high = nums2.length-1;
            if(e1>=0){
                while(low<= high){
                    int mid = (low+high)/2;
                    if((long)e1*nums2[mid] <= dot_pro){
                        c= mid+1;
                        low = mid+1;
                    }
                    else{
                        high = mid-1;
                    }
                }

                ans += c;
            }

            else{
                while(low<= high){
                    int mid = (low+high)/2;
                    if((long)e1*nums2[mid] <= dot_pro){
                        c=nums2.length-mid;
                        high = mid-1;
                    }
                    else{
                        low = mid+1;
                    }
                }

                ans += c;
            }
        }
        return ans;
    }
}