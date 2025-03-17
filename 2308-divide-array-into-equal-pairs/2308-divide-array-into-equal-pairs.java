class Solution {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();  
        for (int num : nums) {  
            counts.put(num, counts.getOrDefault(num, 0) + 1);  
        }  

        for (int c : counts.values()) {  
            if (c % 2 != 0) {  
                return false;  
            }  
        }  

        return true;
    }
}