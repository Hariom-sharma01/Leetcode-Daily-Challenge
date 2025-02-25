class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;   
        long oc= 0, ec = 1;  
        long cs= 0;  
        long ans = 0;  

        for (int i = 0; i < arr.length; i++) {  
            cs+= arr[i];    
            if (cs% 2 == 0) {  
                ans = (ans + oc) % MOD;  
                ec++;  
            } else {   
                ans = (ans+ec) % MOD;  
                oc++;  
            }  
        }  

        return (int) ans;  
    }
}