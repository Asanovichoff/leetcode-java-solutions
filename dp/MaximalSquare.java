/**
 * Problem: Maximal Square
 * Platform: LeetCode
 *
 * Approach (Dynamic Programming):
 * 1. Use a dynamic programming array to keep track of the maximum square size at each cell.
 * 2. Use a loop to iterate through the matrix and update the dynamic programming array.
 * 3. Return the maximum square size.
 */

class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxArea = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] height = new int[cols+1];

        for(int r = 0; r<rows; r++){
            for(int c = 0; c<cols; c++){
                if(matrix[r][c]=='1'){
                    height[c]++;
                }else{
                    height[c] = 0;
                }
            }
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < height.length; j++) {
                while (!stack.isEmpty() && height[stack.peek()] > height[j]) {
                    int h = height[stack.pop()];
                    int w = stack.isEmpty() ? j : j - stack.peek() - 1;
                    int side = Math.min(h, w);
                    maxArea = Math.max(maxArea, side * side);
                }
                stack.push(j);
            }

        }
        return maxArea;
    }
}