class Solution {
    public int minTaps(int n, int[] ranges) {
        int[][] arr=new int[n+1][2];
        for(int i=0;i<=n;i++){
            int l=i-ranges[i];
            int r=i+ranges[i];
            arr[i][0]=l<0 ?0 :l;
            arr[i][1]=r>n ?n:r;
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        
        int c=0,l=0,i=0;
        int mr=0;
        while(l<n){
            while(i<=n && arr[i][0]<=l){
                mr=Math.max(mr,arr[i][1]);
                i++;
            }
            if(mr==l) return -1;
            l=mr;
            c++;
        }

        return c;
    }
}