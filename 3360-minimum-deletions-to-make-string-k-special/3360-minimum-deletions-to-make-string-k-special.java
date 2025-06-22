class Solution {
    public int minimumDeletions(String word, int k) {
        int[] freq=new int[26];
        for(char ch:word.toCharArray()){
            freq[ch-'a']++;
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            if(freq[i]==0) continue;
            int base=freq[i];
            int del=0;
            for(int j=0;j<26;j++){
                if(freq[j]<freq[i]){
                    del+=freq[j];   
                } 
                else if(freq[j]>base+k){
                    del+=freq[j]-base-k;
                }
            }
            ans=Math.min(ans,del);
        }
        return ans;
    }
}