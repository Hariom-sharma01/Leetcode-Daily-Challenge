class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
         Arrays.sort(arr);
        List<List<Integer>> result = new LinkedList<>();
       for(int i=0;i<arr.length-2;i++){
           if(i==0 ||(i>0 && arr[i]!=arr[i-1])){
               int l=i+1;
               int h=arr.length-1;
               int sum=0-arr[i];

               // it is the two pointer approach 
               while(l<h){
                   if(arr[l]+arr[h]==sum){
                       result.add(Arrays.asList(arr[i],arr[l],arr[h]));
                       while(l<h && arr[l]==arr[l+1])    l++;
                       while(l<h && arr[h]==arr[h-1])  h--;
                       l++;
                       h--;
                   }
                   else if(arr[l]+arr[h]<sum){
                       l++;
                   }
                   else{
                       h--;
                   }
               }
           }
       }
       return result; 


    }
   
   
}