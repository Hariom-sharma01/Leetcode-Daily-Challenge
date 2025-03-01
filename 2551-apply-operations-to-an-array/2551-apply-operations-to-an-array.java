class Solution {
    public int[] applyOperations(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]==arr[i+1]){
                arr[i]=arr[i]*2;
                arr[i+1]=0;
            }
        }
        int[] result = new int[arr.length];  
        int index = 0;  

        for (int num : arr) {  
            if (num != 0) {  
                result[index++] = num;  
            }  
        }  
        return result;
    }
}