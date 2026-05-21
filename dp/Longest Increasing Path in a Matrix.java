/**
 * Problem: Longest Increasing Path in a Matrix
 * Platform: LeetCode
 *
 * Approach (Dynamic Programming):
 * 1. Use a dynamic programming approach to find the longest increasing path in a matrix.
 * 2. Use a loop to iterate through the matrix and find the longest increasing path.
 * 3. Return the longest increasing path.
 */
/**
 * Time Complexity: O(m*n)
 * Space Complexity: O(m*n)
 * 
 * Explanation:
 * 1. We use a dynamic programming approach to find the longest increasing path in a matrix.
 * 2. We use a loop to iterate through the matrix and find the longest increasing path.
 * 3. We return the longest increasing path.
 */
class Solution {
    private Integer[][] visited;
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        visited = new Integer[m][n];
        int maxNum = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (visited[r][c] != null){
                    maxNum = Math.max(maxNum, visited[r][c]);
                    continue;
                } 
                visited[r][c] = dfs(r, c, matrix, -1);
                maxNum = Math.max(maxNum, visited[r][c]);

            }
        }
        return maxNum;

    }
    private int dfs (int r, int c, int[][] matrix, int prevNum) {
        if (r < 0 || c < 0 || r>=matrix.length || c>= matrix[0].length) return 0;
        if (prevNum >= matrix[r][c]) return 0;
        if (visited[r][c] != null) return visited[r][c];
        visited[r][c] = 1+ Math.max(dfs (r+1, c,matrix, matrix[r][c]), 
                                    Math.max(dfs(r-1,c,matrix, matrix[r][c]), 
                                    Math.max(dfs(r,c+1, matrix, matrix[r][c]), dfs(r, c-1, matrix, matrix[r][c]))));
        return visited[r][c];
    }
    // spase : m*n;
    // time: m*n;
}
