class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();  
        int opr= k; 

        for (int i = 0; i <= n - k; i++) {  
            int temp = 0;  
            for (int j = i; j < i + k; j++) {  
                if (blocks.charAt(j) == 'W') {  
                    temp++;  
                }  
            }  
            opr = Math.min(opr, temp);  
        }  

        return opr;
    }
}