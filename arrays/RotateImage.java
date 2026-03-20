/**
 * Problem: Rotate Image
 * Platform: LeetCode
 *
 * Approach (Simulation):
 * 1. Use a simulation approach to rotate the image.
 * 2. Use a loop to iterate through the image and rotate the image.
 * 3. Return the result.
 */
/**
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a simulation approach to rotate the image.
 * 2. We use a loop to iterate through the image and rotate the image.
 * 3. We return the result.
 */
class Solution {
    public void rotate(int[][] matrix) {
        int l = 0;
        int r = matrix.length-1;
        while (l<r){
            for (int i = 0; i < r-l; i++){
                int top = l;
                int bottom = r;
                
                int topLeft = matrix[top][l+i];
                matrix[top][l+i] = matrix[bottom-i][l];
                matrix[bottom-i][l] = matrix[bottom][r-i];
                matrix[bottom][r-i] = matrix[top+i][r];
                matrix[top+i][r] = topLeft;
            }
            r--;
            l++;
        }
        
    }
}
