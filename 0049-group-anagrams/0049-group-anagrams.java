class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,ArrayList<String>> map=new HashMap<>();

        for(String s:strs){
            String key=findKey(s);
            if(map.containsKey(key)){
                map.get(key).add(s);
            }
            else{
                ArrayList<String> ls=new ArrayList<>();
                ls.add(s);
                map.put(key,ls);
            }
        }
        List<List<String>> ans=new ArrayList<>();
        for(String s:map.keySet()){
            ans.add(map.get(s));
        }
        return ans;

    }
    public static String findKey(String str){
        char[] arr=new char[26];
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            arr[ch-'a']++;
        }

        return new String(arr);

    }
}