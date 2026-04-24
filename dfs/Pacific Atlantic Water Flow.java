/**
 * Problem: Pacific Atlantic Water Flow
 * Platform: LeetCode
 *
 * Approach (Depth-First Search):
 * 1. Use a depth-first search to find the Pacific and Atlantic waters.
 * 2. Use a loop to iterate through the grid and find the Pacific and Atlantic waters.
 * 3. Return the result.
 */
/**
 * Time Complexity: O(m*n)
 * Space Complexity: O(m*n)
 */
/**
 * Explanation:
 * 1. We use a depth-first search to find the Pacific and Atlantic waters.
 * 2. We use a loop to iterate through the grid and find the Pacific and Atlantic waters.
 * 3. We return the result.
 */
class Solution {
    private int rows, cols;
    private boolean[][] pacific;
    private boolean[][] atlantic;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        pacific = new boolean[rows][cols];
        atlantic = new boolean[rows][cols];

        for (int c = 0; c < cols; c++) {
            dfs(0, c, pacific, heights);        // top
            dfs(rows - 1, c, atlantic, heights); // bottom
        }

        for (int r = 0; r < rows; r++) {
            dfs(r, 0, pacific, heights);        // left
            dfs(r, cols - 1, atlantic, heights); // right
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, boolean[][] visited,int[][] heights) {
        visited[r][c] = true;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr < 0 || nc < 0 || nr >= rows || nc >= cols) continue;

            if (visited[nr][nc]) continue;
            if (heights[nr][nc] < heights[r][c]) continue;
            dfs(nr, nc, visited, heights);
        }
    }
}