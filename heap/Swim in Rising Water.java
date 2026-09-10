/** problem: Swim in Rising Water
 * 
 * approach 1: heap
 * time complexity: O(n^2 * log(n))
 * space complexity: O(n^2)
 * 
 * explanation:
 * 1. use a heap to store the cells
 * 2. use a pointer to iterate through the cells
 * 3. return the result
 */

class Solution {
    private int n;
    private int[][] grid;
    private PriorityQueue<int[]> minHeap;
    private boolean[][] visited;
    private int[][] dirs;
    public int swimInWater(int[][] grid) {
        n = grid.length;
        this.grid = grid;
        visited = new boolean[n][n];
        dirs = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
        minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        minHeap.offer(new int[]{grid[0][0],0,0});
        visited[0][0] = true;

        while(!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int t = cur[0];
            int r = cur[1];
            int c = cur[2];
            if (r == n-1 && c == n-1) return t;
            for (int[] dir : dirs) {
                int nr  = r + dir[0];
                int nc = c + dir[1];
                if (nr >=0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    minHeap.offer(new int[]{Math.max(t, grid[nr][nc]), nr, nc});
                    visited[nr][nc] = true;
                } 
            }

        }
        return -1;
    }
}

//[0,1,2,3,4]
//[9,8,7,6,10]
//[0,1,22,19,20]
//[0,1,2,3,4]