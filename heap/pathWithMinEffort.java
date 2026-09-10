/*
 * 1631. Path With Minimum Effort
 * https://leetcode.com/problems/path-with-minimum-effort/
 * approach: dijkstra's algorithm
 * time complexity: O(E log V)
 * space complexity: O(V)
 * 
 * 1. Initialize a priority queue to store the cells in the path.
 * 2. Add the starting cell to the priority queue.
 * 3. While the priority queue is not empty, poll the cell with the minimum effort.
 * 4. If the cell is the target cell, return the effort.
 * 5. Otherwise, add the cell to the visited set and add the neighboring cells to the priority queue.
 * 6. Return the minimum effort.
 */

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[][] DIRS = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0,0,0}); //[effort,row,col]
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curEffort = cur[0], r = cur[1], c = cur[2];
            if (r == rows-1 && c == cols-1) return curEffort;
            if (visited[r][c]) continue;
            visited[r][c] = true;
            for (int[] dir : DIRS) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >=0 && nc >= 0 && nr < rows && nc < cols && !visited[nr][nc]) {
                    int edge = Math.abs(heights[nr][nc] - heights[r][c]);
                    int newEffort = Math.max(curEffort, edge);
                    pq.offer(new int[] {newEffort,nr,nc});
                }
            }

        }
        return -1;
    }
}