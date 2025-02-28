class Solution {

    static String dp[][];

    static String LCS(String s1, String s2, int i, int j){  

        if(i>=s1.length() || j>=s2.length()){
            return "";
        }

        if(dp[i][j]!="") return dp[i][j];
        char ch1 = s1.charAt(i);
        char ch2 = s2.charAt(j);

        if(ch1==ch2){
            return dp[i][j] = ch1+LCS(s1,s2,i+1,j+1);
        }else{
            String a = LCS(s1,s2,i+1,j);
            String b =  LCS(s1,s2,i,j+1);

            return dp[i][j] = (a.length()>b.length()) ? a:b;
        }
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        dp = new String[1005][1005];

        for(int i=0; i<1005; i++){
            for(int j=0; j<1005; j++) dp[i][j] = "";
        }

        String s = LCS(str1,str2,0,0);

        String ans = "";

        int i=0,j=0;
    
        for(int k=0; k<s.length(); k++){

            char c = s.charAt(k);

            while(str1.charAt(i)!=c) ans+=str1.charAt(i++);
            while(str2.charAt(j)!=c) ans+=str2.charAt(j++);

            ans += c;
            i++;
            j++;    
        }

         return ans+str1.substring(i)+str2.substring(j);
    }
}