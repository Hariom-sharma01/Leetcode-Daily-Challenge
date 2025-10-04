class Solution {
    public int maxArea(int[] arr) {
        int n=arr.length;
        int l=0;
        int h=n-1;
        int max=0;
        while(l<=h){
            int area=Math.min(arr[l],arr[h])*(h-l);
            if(max<area)
            max=area;
            if(arr[h]>arr[l])
            l++;
            else
            h--;
          
        }
        return max;
        
    }
}