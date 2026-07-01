/**
 * Problem: Find the Safest Path in a Grid
 * Platform: LeetCode
 *
 * Approach (Breadth First Search):
 * 1. Use a breadth first search approach to find the safest path in the grid.
 * 2. Use a loop to iterate through the grid and find the safest path in the grid.
 * 3. Return the safest path in the grid.
 */ 
/**
 * Time Complexity: O(n^2 log n)
 * Space Complexity: O(n^2)
 * 
 * Explanation:
 * 1. We use a breadth first search approach to find the safest path in the grid.
 * 2. We use a loop to iterate through the grid and find the safest path in the grid.
 * 3. We return the safest path in the grid.
 */
class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1)
            return 0;

        int[][] dist = new int[n][n];
        for (int[] row : dist)
            Arrays.fill(row, -1);

        Queue<int[]> queue = new ArrayDeque<>();
        // Multi-source BFS: start from every thief
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.get(r).get(c) == 1) {
                    dist[r][c] = 0;
                    queue.offer(new int[]{r, c});
                }
            }
        }

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        // Compute distance to nearest thief
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n)
                    continue;

                if (dist[nr][nc] != -1)
                    continue;

                dist[nr][nc] = dist[r][c] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }

        // Max heap: {currentSafeness, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );

        boolean[][] visited = new boolean[n][n];
        pq.offer(new int[]{dist[0][0], 0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            int safe = cur[0];
            int r = cur[1];
            int c = cur[2];

            if (visited[r][c])
                continue;
            visited[r][c] = true;

            if (r == n - 1 && c == n - 1)
                return safe;

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n)
                    continue;

                if (visited[nr][nc])
                    continue;

                pq.offer(new int[]{
                    Math.min(safe, dist[nr][nc]),
                    nr,
                    nc
                });
            }
        }

        return 0;
    }
}