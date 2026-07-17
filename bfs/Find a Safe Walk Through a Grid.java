/** problem: Find a Safe Walk Through a Grid
 * 
 * approach 1: bfs
 * time complexity: O(m * n)
 * space complexity: O(m * n)
 * 
 * explanation:
 * 1. initialize the distance array
 * 2. initialize the deque
 * 3. initialize the directions
 * 4. iterate through the deque
 * 5. update the distance array
 * 6. return the result
 */
class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Deque<int[]> deque = new ArrayDeque<>();

        dist[0][0] = grid.get(0).get(0);
        deque.offerFirst(new int[]{0, 0});

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int r = cur[0];
            int c = cur[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                int w = grid.get(nr).get(nc);
                int nd = dist[r][c] + w;

                if (nd < dist[nr][nc]) {
                    dist[nr][nc] = nd;
                    if (w == 0) {
                        deque.offerFirst(new int[]{nr, nc});
                    } else {
                        deque.offerLast(new int[]{nr, nc});
                    }
                }
            }
        }

        return dist[m - 1][n - 1] < health;
    }
}