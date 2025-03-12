class Solution {
    public int maximumCount(int[] nums) {
        int cp=0,cn=0;
        for(int i:nums){
            if(i>0)cp++;
            if(i<0)cn++;
        }
        return Math.max(cp,cn);
    }
}