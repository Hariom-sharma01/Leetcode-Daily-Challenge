class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans= new ArrayList<>();
        if (words == null || words.length == 0 || groups == null || groups.length == 0 || words.length != groups.length) {
            return ans;
        }
        int temp = -1;
        for (int i = 0; i < words.length; i++) {
            if (groups[i] != temp) {
                ans.add(words[i]);
                temp = groups[i];
            }
        }

        return ans;
    }
}