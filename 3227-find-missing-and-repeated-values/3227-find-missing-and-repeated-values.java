class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                map.put(grid[i][j],map.getOrDefault(grid[i][j],0)+1);
            }
        }
        int[] ans=new int[2];
        for(int i=1;i<=grid.length*grid.length;i++){
            if(map.containsKey(i)){
                if(map.get(i)==2) ans[0]=i;
            }
            else{
                ans[1]=i;
            }
        }

        return ans;
    }
}