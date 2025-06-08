class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ls=new ArrayList<Integer>();
        lexico(0,n,ls);
        ls.remove(0);
        return ls;
        
    }
    public static void lexico(int curr,int n,List ls){
        if(curr>n) return;
        ls.add(curr);
        int i=0;
        if(curr ==0)
        i=1;
        for(;i<=9;i++){
            lexico(curr*10+i, n,ls);

        }

     }
}