class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int ind=-1;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                ind=i;
                break;
            }
        }
        return ind;
    }
}