class Solution {
    public String triangleType(int[] arr) {
        
        if(arr[0]>=arr[1]+arr[2] || arr[1]>=arr[0]+arr[2] || arr[2]>=arr[1]+arr[0]){
            return "none";

        }
        else{
            if(arr[0]==arr[1] && arr[1]==arr[2]){
                return "equilateral";

            }
            else if(arr[0]==arr[1] || arr[1]==arr[2] || arr[2]==arr[0]){
                return "isosceles";
    
            }
            else{
                return "scalene";
                
            }
        }
        
    }
}