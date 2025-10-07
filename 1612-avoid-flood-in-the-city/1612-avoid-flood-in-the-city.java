class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        Map<Integer, Integer> last = new HashMap<>();
        TreeSet<Integer> zeros = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake > 0) {
                res[i] = -1;
                if (last.containsKey(lake)) {
                    int prev = last.get(lake);
                    Integer dryDay = zeros.higher(prev);
                    if (dryDay == null) {
                        return new int[0];
                    }
                    res[dryDay] = lake; 
                    zeros.remove(dryDay); 
                }
                last.put(lake, i);
            } else { 
                zeros.add(i);
            }
        }
        return res;
    }
}