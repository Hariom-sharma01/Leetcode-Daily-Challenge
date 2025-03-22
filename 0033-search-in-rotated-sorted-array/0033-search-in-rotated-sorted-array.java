class Solution {
    public int search(int[] arr, int t) {
        int l=0;
        int h=arr.length-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(arr[mid]==t)return mid;

            if(arr[l]<=arr[mid]){
                if(arr[l]<=t && t<=arr[mid])
                h=mid-1;
                else l=mid+1;
            }
            else{
                if(arr[mid]<=t && t<=arr[h])
                l=mid+1;
                else h=mid-1;
            }
        }
    return -1;
    }
}