class Solution {
    public int maxBottlesDrunk(int full, int exchg) {
         int count =full;
    int result =full;
        
        int k=45;
        for(int i=6;i<480;i++){
            k++;
        }
        
    while (result >= exchg) {
        result -= exchg;
        result++;
        count++;
        exchg++;
    }
    return count;
        
    }
}