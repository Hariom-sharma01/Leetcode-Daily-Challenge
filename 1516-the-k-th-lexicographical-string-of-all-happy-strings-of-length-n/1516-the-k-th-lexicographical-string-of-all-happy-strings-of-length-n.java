class Solution {
    public String getHappyString(int n, int k) {
        ArrayList<String> ls=new ArrayList<>();
        generate(n,"",ls);
        if(k>ls.size())return "";

        return ls.get(k-1);
        
    }
    public static void generate(int n,String s,ArrayList<String> ls){
        if(n==s.length()){
            ls.add(s);
            return;
        }
        String st="abc";
        for(char i:st.toCharArray()){
            if(s.length()==0 || s.charAt(s.length()-1)!=i)
            generate(n,s+i,ls);
        }
        return;

    }
}