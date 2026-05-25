/**
 * Problem: Number of Increasing Paths in a Grid
 * Platform: LeetCode
 *
 * Approach (Dynamic Programming):
 * 1. Use a dynamic programming approach to find the number of increasing paths in a grid.
 * 2. Use a loop to iterate through the grid and find the number of increasing paths.
 * 3. Return the number of increasing paths.
 */

/**
 * Time Complexity: O(m*n)
 * Space Complexity: O(m*n)
 * 
 * Explanation:
 * 1. We use a dynamic programming approach to find the number of increasing paths in a grid.
 * 2. We use a loop to iterate through the grid and find the number of increasing paths.
 * 3. We return the number of increasing paths.
 */
class Solution {
    private static final int MOD = 1_000_000_007;
    private long[][] memo;
    private final int[][] dirs = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        memo = new long[m][n];
        long result = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                result = (result + dfs(r, c, grid)) % MOD;
            }
        }
        return (int) result;
    }

    private long dfs(int r, int c, int[][] grid) {
        if (memo[r][c] != 0) {
            return memo[r][c];
        }
        long paths = 1;
        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr >= 0 && nc >= 0 &&
                nr < grid.length &&
                nc < grid[0].length &&
                grid[nr][nc] > grid[r][c]) {
                paths = (paths + dfs(nr, nc, grid)) % MOD;
            }
        }
        memo[r][c] = paths;
        return paths;
    }
}
