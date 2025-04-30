class Solution {
    public int findNumbers(int[] nums) {
        String a=Arrays.toString(nums);
        String ar[]=a.substring(1,a.length()-1).split(", ");
        int ans=0;
        for(int i=0;i<nums.length;i++){
            if(ar[i].length()%2==0)ans++;
        }
        return ans;
    }
}