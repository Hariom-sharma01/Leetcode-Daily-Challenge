class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> p = new PriorityQueue<>();
        for (int i : nums) p.add((long) i);
        int c = 0;
        while(p.peek()<k){
           long a = p.poll();
            long b = p.poll();
            p.add(Math.min(a, b) * 2 + Math.max(a, b));
            c++;
        }
        return c;
    }
}