import java.util.*;

class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> count= new HashMap<>();
        for (String w : words) {
            count.put(w, count.getOrDefault(w, 0) + 1);
        }

        int ans = 0;
        boolean f = false;

        for (String w : count.keySet()) {
            String rev = new StringBuilder(w).reverse().toString();
            if (w.compareTo(rev) < 0) {
                ans += 4 * Math.min(count.get(w), count.getOrDefault(rev, 0));
            } else if (w.equals(rev)) {
                int c = count.get(w);
                ans += (c / 2) * 4;
                if (c % 2 == 1) {
                    f = true;
                }
            }
        }
        if (f) {
            ans += 2;
        }

        return ans;
    }
}
