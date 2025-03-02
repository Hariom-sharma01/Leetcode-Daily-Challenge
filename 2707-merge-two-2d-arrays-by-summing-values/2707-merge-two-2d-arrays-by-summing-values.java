class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i][0],map.getOrDefault(nums1[i][0],0)+nums1[i][1]);
        }
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i][0],map.getOrDefault(nums2[i][0],0)+nums2[i][1]);
        }
        int[][] ans=new int[map.size()][2];
        int ind=0;
        for(int i:map.keySet()){
            ans[ind][0]=i;
            ans[ind][1]=map.get(i);
            ind++;
        }
        return ans;
    }
}