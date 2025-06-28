class Solution {
    public String robotWithString(String s) {
        int[] feq = new int[26];
        int n=s.length();
        Stack<Integer> st=new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            feq[s.charAt(i)-'a']++;
        }

        for(int i=0;i<n;i++){
            int idx=s.charAt(i)-'a';
            if(ispos(idx-1, feq)){
                st.push(idx);
                feq[idx]--;
            }else{
                sb.append((char)(idx+'a'));
                feq[idx]--;
                while(st.size()>0 && !ispos(st.peek()-1, feq)){
                    sb.append((char)(st.pop()+'a'));
                }
            }   
        }
        while(st.size()>0){
            sb.append((char)(st.pop()+'a'));
        }
        return sb.toString();
    }
    public boolean ispos(int idx, int[] feq){
        for(int i=0;i<=idx;i++){
            if(feq[i]!=0)return true;
        }
        return false;
    }
}