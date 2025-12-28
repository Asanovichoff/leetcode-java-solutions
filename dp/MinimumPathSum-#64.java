/**
 * Problem: Minimum Path Sum
 * Platform: LeetCode
 *
 * Approach (Dynamic Programming):
 * 1. Use a loop to iterate through the array and calculate the minimum path sum.
 * 2. Return the minimum path sum.
 *
 * Time Complexity: O(m*n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a loop to iterate through the array's first row and column to calculate the minimum path sum.
 * 2. We use a loop to iterate through the array and calculate the minimum path sum for each cell by adding the minimum of the top and left cell to the current cell.
 * 2. We return the minimum path sum.
 */

class Solution {
    public int minPathSum(int[][] grid) {
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int j = 1; j < grid[0].length; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        for(int r = 1; r<grid.length;r++){
            for(int c = 1; c<grid[0].length; c++){
                grid[r][c] = Math.min(grid[r-1][c],grid[r][c-1])+grid[r][c];
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}