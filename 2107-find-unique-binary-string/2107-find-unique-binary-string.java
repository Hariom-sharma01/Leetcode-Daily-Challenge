class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> set=new HashSet<>();
        Collections.addAll(set,nums); 
        return rec(set,nums[0].length(),"");
        
    }
    public static String rec(HashSet<String> set,int len,String ans){
        if(ans.length()==len){
            if(!set.contains(ans)){
                return ans;
            }
            return null;
        }
        String st=rec(set,len,ans+"0");
        if(st!=null) return st;
        return rec(set,len,ans+"1");
    }
}