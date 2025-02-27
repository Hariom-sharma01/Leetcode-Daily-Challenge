class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;  
        Set<Integer> set = new HashSet<>();  
        for (int i : arr) {  
            set.add(i);  
        }  
        
        int ans = 0;  
        for (int i = 0; i < n; i++) {  
            for (int j = i + 1; j < n; j++) {  
                int x = arr[i];
                int y = arr[j];
                int cl = 2;  
                while (set.contains(x + y)) {  
                    int z = x + y;  
                    x = y;  
                    y = z;  
                    cl++;  
                }  
                ans = Math.max(ans, cl);  
            }  
        }  

        return ans >= 3 ? ans : 0;
    }
}