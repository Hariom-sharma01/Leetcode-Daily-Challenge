class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0;  
        int n = s.length();  
        int l= 0;  
        int[] arr = new int[3];

        for (int r = 0; r < n; r++) {  
            arr[s.charAt(r) - 'a']++;
            while (arr[0] > 0 && arr[1] > 0 && arr[2] > 0) {  
                count += (n - r);
                arr[s.charAt(l) - 'a']--;
                l++; 
            }  
        }  

        return count;
    }
}