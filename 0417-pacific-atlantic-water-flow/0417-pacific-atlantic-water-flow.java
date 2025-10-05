class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] atl = new boolean[m][n];
        boolean[][] pac = new boolean[m][n];

        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < m; i++){
            check(heights,atl,i,n-1,heights[i][n-1]);
            check(heights,pac,i,0,heights[i][0]);
        }

        for(int j = 0; j < n; j++){
            check(heights,atl,m-1,j,heights[m-1][j]);
            check(heights,pac,0,j,heights[0][j]);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(atl[i][j] && pac[i][j]) res.add(Arrays.asList(i,j));
            }
        }
        return res;
    }
    public void check(int[][] heights, boolean[][] vis, int r,int c, int lh){
        int m = heights.length;
        int n = heights[0].length;

        if(r < 0 || c < 0 || r >= m || c >= n || vis[r][c] || heights[r][c] < lh) return;

        vis[r][c] = true;
        check(heights, vis, r + 1, c, heights[r][c]);
        check(heights, vis, r - 1, c, heights[r][c]);
        check(heights, vis, r, c + 1, heights[r][c]);
        check(heights,vis, r, c - 1, heights[r][c]);
    }
}