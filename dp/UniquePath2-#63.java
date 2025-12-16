/**
 * Problem: Unique Paths II
 * Platform: LeetCode
 *
 * Approach (Two-pass in-place DP):
 * 1. First pass:
 *    - Mark all obstacle cells (value = 1) as -1.
 *    - This allows us to distinguish obstacles from unprocessed cells.
 *
 * 2. Initialization:
 *    - Set the starting cell (0,0) to 1, representing one valid path
 *      if it is not an obstacle.
 *
 * 3. Second pass (Dynamic Programming):
 *    - If a cell is marked as -1, it is an obstacle → set paths to 0.
 *    - Otherwise, accumulate paths from:
 *        - the top cell (r - 1, c)
 *        - the left cell (r, c - 1)
 *
 * DP Transition:
 * paths[r][c] = paths[r - 1][c] + paths[r][c - 1]
 *
 * Time Complexity: O(m * n)
 * Space Complexity: O(1) (in-place modification of obstacleGrid)
 */

class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // If the starting cell is an obstacle, no paths exist
        if (obstacleGrid[0][0] == 1) return 0;

        // First pass: mark obstacles as -1
        for (int r = 0; r < obstacleGrid.length; r++) {
            for (int c = 0; c < obstacleGrid[0].length; c++) {
                if (obstacleGrid[r][c] == 1) {
                    obstacleGrid[r][c] = -1;
                }
            }
        }

        // Initialize the starting position
        obstacleGrid[0][0] = 1;

        // Second pass: compute number of paths
        for (int r = 0; r < obstacleGrid.length; r++) {
            for (int c = 0; c < obstacleGrid[0].length; c++) {

                if (obstacleGrid[r][c] == -1) {
                    // Obstacle cell contributes zero paths
                    obstacleGrid[r][c] = 0;
                } else {
                    if (r - 1 >= 0) {
                        obstacleGrid[r][c] += obstacleGrid[r - 1][c];
                    }
                    if (c - 1 >= 0) {
                        obstacleGrid[r][c] += obstacleGrid[r][c - 1];
                    }
                }
            }
        }

        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}