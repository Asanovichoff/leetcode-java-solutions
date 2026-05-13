/**
 * Problem: Minimum Falling Path Sum II
 * Platform: LeetCode
 *
 * Approach (Dynamic Programming):
 * 1. Use a dynamic programming approach to find the minimum falling path sum.
 * 2. Use a nested loop to iterate through the grid and find the minimum falling path sum.
 * 3. Return the minimum falling path sum.
 */

/**
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a dynamic programming approach to find the minimum falling path sum.
 * 2. We use a nested loop to iterate through the grid and find the minimum falling path sum.
 * 3. We return the minimum falling path sum.
 */
class Solution {
    public int minFallingPathSum(int[][] grid) {
        int minSum = Integer.MAX_VALUE;
        for (int r = 1; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                int minNum = findMin(grid, r-1, c);
                grid[r][c] += minNum;
            }
        }

        for (int c = 0; c < grid[0].length; c++) {
            minSum = Math.min(minSum, grid[grid.length-1][c]);
        }

        return minSum;
    }
    private int findMin(int[][]grid, int r, int c) {
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            if (i == c) continue;
            minNum = Math.min(minNum, grid[r][i]);
        }
        return minNum;
    }
}
