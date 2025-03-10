class Solution {
    public long countOfSubstrings(String word, int k) {
        return atleastK(word,k)-atleastK(word,k+1);
    }
    public boolean isVowel(char c){
        if(c=='a' || c=='e' ||  c=='i' ||  c=='o' ||  c=='u' )return true;
        return false;
    }
    public long atleastK(String word,int k){
        HashMap<Character,Integer> vowel = new HashMap<>();
        int consonent = 0;
        int left = 0;
        long result = 0;
        for(int right = 0; right<word.length();right++){
            char ch = word.charAt(right);
            if(isVowel(ch)){
                vowel.put(ch,vowel.getOrDefault(ch,0)+1);
            }else{
                consonent++;
            }
            while(vowel.size()==5 && consonent>=k){
                char ch2 = word.charAt(left);
                result += word.length()-right;
                if(isVowel(ch2)){
                    vowel.put(ch2,vowel.get(ch2)-1);
                    if(vowel.get(ch2)==0){
                        vowel.remove(ch2);
                    }
                }else{
                    consonent--;
                } 
                left++;
            }
        }
        return result;
    }
}