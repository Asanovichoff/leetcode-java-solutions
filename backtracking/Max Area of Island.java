/**
 * Problem: Max Area of Island
 * Platform: LeetCode
 *
 * Approach (Depth-First Search):
 * 1. Use a depth-first search to find the maximum area of an island.
 * 2. Use a loop to iterate through the grid and find the maximum area of an island.
 * 3. Return the maximum area of an island.
 */
/**
 * Time Complexity: O(m*n)
 * Space Complexity: O(m*n)
 * 
 * Explanation:
 * 1. We use a depth-first search to find the maximum area of an island.
 * 2. We use a loop to iterate through the grid and find the maximum area of an island.
 * 3. We return the maximum area of an island.
 */
class Solution {
    int maxArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for (int r = 0; r < grid.length; r++){
            for (int c = 0; c <grid[0].length; c++){
                if (grid[r][c] == 1){
                    int area = dfs(r, c, grid);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
    public int dfs(int r, int c, int[][] grid){
        if (r<0 || c<0 || r>=grid.length || c>= grid[0].length || grid[r][c] == 0) return 0;
        grid[r][c] = 0;
        return 1 + dfs(r+1, c, grid) + dfs(r-1, c, grid) + dfs(r, c+1, grid) + dfs(r, c-1, grid);
    }
}
