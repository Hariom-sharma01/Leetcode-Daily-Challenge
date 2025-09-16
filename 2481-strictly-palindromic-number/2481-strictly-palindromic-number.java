class Solution {
    public boolean isStrictlyPalindromic(int n) {
        for(int i=2;i<=n-2;i++){
        if(!palindrome(baseConverter(n,i))){
            return false;
        }
       }
       return true;
    }
    public String baseConverter(int n,int base){
        StringBuilder result=new StringBuilder("");
        while(n>0){
            int rem=n%base;
            result.insert(0,rem);
            n=n/2;
        }
        return result.toString();
    }
    public boolean palindrome(String s){
        StringBuilder sb=new StringBuilder(s);
        if(s==sb.reverse().toString()){
            return true;
        }
        return false;
    }
}