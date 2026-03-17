/**
 * Problem: Rotting Oranges
 * Platform: LeetCode
 *
 * Approach (Breadth-First Search):
 * 1. Use a queue to keep track of the oranges that are rotting.
 * 2. Use a loop to iterate through the grid and find the oranges that are rotting.
 * 3. Return the result.
 */
/**
 * Time Complexity: O(m*n)
 * Space Complexity: O(m*n)
 * 
 * Explanation:
 * 1. We use a queue to keep track of the oranges that are rotting.
 * 2. We use a loop to iterate through the grid and find the oranges that are rotting.
 * 3. We return the result.
 */
class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    q.add(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) return 0;

        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // BFS
        while (!q.isEmpty()) {
            int size = q.size();
            boolean rottenThisMinute = false;

            for (int i = 0; i < size; i++) {
                int[] pos = q.poll();
                int r = pos[0];
                int c = pos[1];

                for (int[] dir : directions) {
                    int newR = r + dir[0];
                    int newC = c + dir[1];
                    if (newR >= 0 && newR < rows && newC >= 0 && newC < cols && grid[newR][newC] == 1) {
                        grid[newR][newC] = 2; 
                        fresh--;
                        q.add(new int[]{newR, newC});
                        rottenThisMinute = true;
                    }
                }
            }
            if (rottenThisMinute) {
                minutes++;
            }
        }
        return fresh == 0 ? minutes : -1;
    }
}