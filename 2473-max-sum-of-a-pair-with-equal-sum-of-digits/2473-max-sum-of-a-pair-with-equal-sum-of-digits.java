class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int ds=sumOfDigits(nums[i]);
            if(!map.containsKey(ds)){
                map.put(ds,new ArrayList<>());
                map.get(ds).add(nums[i]);
            }
            else{
                map.get(ds).add(nums[i]);
            }
        }
        int max=-1;
        for(int i:map.keySet()){
            int sum=-1;
            if(map.get(i).size()>=2){
                Collections.sort(map.get(i));
                sum=map.get(i).get(map.get(i).size()-1)+map.get(i).get(map.get(i).size()-2);
            }
            max=Math.max(sum,max);
        }
        return max;
    }
    public static int sumOfDigits(int n){
        int sum=0;
        while(n>0){
            sum+=n%10;
            n=n/10;
        }
        return sum;
    }
}