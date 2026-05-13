/**
 * Problem: Minimum Falling Path Sum
 * Platform: LeetCode
 *
 * Approach (Dynamic Programming):
 * 1. Use a dynamic programming approach to find the minimum falling path sum.
 * 2. Use a nested loop to iterate through the matrix and find the minimum falling path sum.
 * 3. Return the minimum falling path sum.
 */

/**
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a dynamic programming approach to find the minimum falling path sum.
 * 2. We use a nested loop to iterate through the matrix and find the minimum falling path sum.
 * 3. We return the minimum falling path sum.
 */
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int minSum = Integer.MAX_VALUE;
        if (matrix.length<2) {
            for (int c = 0; c < matrix.length; c++) {
                minSum = Math.min(minSum, matrix[0][c]);
            }
            return minSum;
        }
        for (int r = 1; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                int minNum = matrix[r-1][c];
                if (c > 0) minNum = Math.min(minNum, matrix[r-1][c-1]);
                if (c < matrix[0].length-1) minNum = Math.min(minNum, matrix[r-1][c+1]);
                matrix[r][c] += minNum;

                if (r == matrix.length-1) {
                    minSum = Math.min(minSum, matrix[r][c]);
                }
            }
        }
        return minSum;
    }
}