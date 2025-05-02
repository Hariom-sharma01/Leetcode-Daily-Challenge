class Solution {
    public String pushDominoes(String dominoes) {
        char[] d = dominoes.toCharArray();
        int n = d.length;
        int[] arr = new int[n];
        int force = 0;
        for (int i = 0; i < n; i++) {
            if (d[i] == 'R') {
                force = n; 
            } else if (d[i] == 'L') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            arr[i] += force;
        }
        force = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (d[i] == 'L') {
                force = n;
            } else if (d[i] == 'R') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            arr[i] -= force;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                d[i] = 'R';
            } else if (arr[i] < 0) {
                d[i] = 'L';
            } else {
                d[i] = '.';
            }
        }

        return new String(d);
    }
}