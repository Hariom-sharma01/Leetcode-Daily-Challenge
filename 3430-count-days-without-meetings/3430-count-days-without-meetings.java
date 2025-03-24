class Solution {
    public int countDays(int days, int[][] meetings) {
        if (meetings.length == 0) return days;

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        List<int[]> temp = new ArrayList<>();
        int l = meetings[0][0];
        int r = meetings[0][1];

        for (int i = 1; i < meetings.length; ++i) {
            if (meetings[i][0] <= r + 1) {
                r = Math.max(r, meetings[i][1]);
            } else {
                temp.add(new int[]{l, r});
                l = meetings[i][0];
                r = meetings[i][1];
            }
        }
        temp.add(new int[]{l, r});

        int ans = 0;

        if (temp.get(0)[0] > 1) {
            ans += temp.get(0)[0] - 1;
        }

        for (int i = 1; i < temp.size(); ++i) {
            ans += temp.get(i)[0] - temp.get(i - 1)[1] - 1;
        }

        if (temp.get(temp.size() - 1)[1] < days) {
            ans += days - temp.get(temp.size() - 1)[1];
        }

        return ans;
    }
}