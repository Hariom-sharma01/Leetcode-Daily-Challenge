class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            st.push(ch);
            if(st.size()>=part.length() && st.peek()==part.charAt(part.length()-1)){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<part.length();j++){
                    sb.append(st.pop());
                } 
                sb.reverse();
                if(!sb.toString().equals(part))
                for(int j=0;j<sb.length();j++){
                    st.push(sb.charAt(j));
                }
            }
        }
        StringBuilder ans=new StringBuilder();
        while(!st.isEmpty())
        ans.append(st.pop());
        return ans.reverse().toString();
    }
}