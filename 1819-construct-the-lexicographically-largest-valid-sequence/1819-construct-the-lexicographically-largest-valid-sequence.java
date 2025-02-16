import java.util.Arrays;

class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] result = new int[2 * n - 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(result, -1);
        Backtrack(result, 0, n, visited);
        return result;
    }

    public boolean Backtrack(int[] result, int index, int n, boolean[] visited) {
        if (index >= result.length) {
            return true; 
        }
        if (result[index] != -1) {
            return Backtrack(result, index + 1, n, visited); 
        }
        
        for (int i = n; i > 0; i--) {
            if (visited[i]) {
                continue;
            }
            if (i == 1) {
                result[index] = 1;
                visited[1] = true;
                if (Backtrack(result, index + 1, n, visited)) {
                    return true;
                }
                visited[1] = false;
                result[index] = -1;
            } else {
                int j = index + i;
                if (j < result.length && result[j] == -1) {
                    result[index] = result[j] = i;
                    visited[i] = true;

                    if (Backtrack(result, index + 1, n, visited)) {
                        return true;
                    }

                    visited[i] = false;
                    result[index] = result[j] = -1; 
                }
            }
        }
        return false;
    }

    
}
