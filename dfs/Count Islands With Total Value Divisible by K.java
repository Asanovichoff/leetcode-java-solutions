class Solution {
    private int[][] grid;
    public int countIslands(int[][] grid, int k) {
        this.grid = grid;
        int m = grid.length, n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    long sum = dfs(i, j);
                    if (sum % k == 0) result++;
                }
            }
        }
        return result;
    }
    private long dfs(int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0) return 0;
        long sum = grid[r][c];
        grid[r][c] = 0;
        return sum + dfs(r+1,c) + dfs(r-1, c) + dfs(r, c+1) + dfs(r, c-1);
    }
}