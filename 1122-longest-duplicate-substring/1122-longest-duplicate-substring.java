import java.util.*;

class Solution {
    public String longestDupSubstring(String s) {
        return longestDuplicate(s);
    }

    public String longestDuplicate(String s) {
        int lo = 1, hi = s.length();
        String ans = "";
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            String str = rollingHash(s, mid);
            if (!str.isEmpty()) {
                ans = str;
                lo = mid + 1;  
            } else {
                hi = mid - 1;  
            }
        }
        return ans;
    }

    public String rollingHash(String s, int mid) {
        int prime = 31, mod = 1_000_000_007;
        long hashValue = 0, pow = 1;

        for (int i = mid - 1; i >= 0; i--) {
            hashValue = (hashValue + ((s.charAt(i) - 'a' + 1) * pow) % mod) % mod;
            if (i > 0) pow = (pow * prime) % mod;
        }

        HashMap<Long, ArrayList<Integer>> map = new HashMap<>();
        map.put(hashValue, new ArrayList<>());
        map.get(hashValue).add(0);

        for (int ei = mid, si = 0; ei < s.length(); ei++, si++) {
            hashValue = ((hashValue - ((s.charAt(si) - 'a' + 1) * pow) % mod + mod) % mod);
            hashValue = ((hashValue * prime) % mod + (s.charAt(ei) - 'a' + 1)) % mod;

            if (map.containsKey(hashValue)) {
                for (int i : map.get(hashValue)) {
                    String curr = s.substring(si + 1, ei + 1);
                    String prev = s.substring(i, i + mid);
                    if (curr.equals(prev)) return curr;
                }
            }

            // Add the current hash to the map
            map.putIfAbsent(hashValue, new ArrayList<>());
            map.get(hashValue).add(si + 1);
        }

        return "";
    }

   
}