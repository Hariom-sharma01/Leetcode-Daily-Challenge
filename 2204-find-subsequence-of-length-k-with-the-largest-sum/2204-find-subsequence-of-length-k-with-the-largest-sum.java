class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[] {nums[i], i});
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] indices = new int[k];
        int idx = 0;
        while (!minHeap.isEmpty()) {
            indices[idx++] = minHeap.poll()[1];
        }

        Arrays.sort(indices);

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = nums[indices[i]];
        }

        return result;
    }
}