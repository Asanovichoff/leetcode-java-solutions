/**
 * Problem: Spiral Matrix II
 * Platform: LeetCode
 *
 * Approach (Simulation):
 * 1. Use a while loop to iterate through the matrix.
 * 2. Use a for loop to iterate through the top row.
 * 3. Use a for loop to iterate through the right column.
 * 4. Use a for loop to iterate through the bottom row.
 * 5. Use a for loop to iterate through the left column.
 */
/**
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 * 
 * Explanation:
 * 1. We use a while loop to iterate through the matrix.
 * 2. We use a for loop to iterate through the top row.
 * 3. We use a for loop to iterate through the right column.
 * 4. We use a for loop to iterate through the bottom row.
 * 5. We use a for loop to iterate through the left column.
 * 6. We return the result.
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = n-1;
        int num = 1;
        while (left <= right && top <= bottom){
            for (int i = left; i <= right; i++) {
                result[top][i] = num++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result[i][right] = num++;
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result[bottom][i] = num++;
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result[i][left] = num++;
                }
                left++;
            }

        }
        return result;
    }
}
