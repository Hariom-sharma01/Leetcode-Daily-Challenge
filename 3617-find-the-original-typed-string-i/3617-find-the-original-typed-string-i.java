class Solution {
    public int possibleStringCount(String word) {
        int ans=0;
        int c=1;
        for(int i=0;i<word.length()-1;i++)
        {
           if(word.charAt(i)==word.charAt(i+1))
            c++;
           else
           {
             if(c>1)
             ans+=(c-1);
             c=1;
           }
        }
        ans+=c-1;
        return ans+1;
    }
}