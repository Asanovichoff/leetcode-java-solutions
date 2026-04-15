/**
 * Problem: Min Cost to Connect All Points
 * Platform: LeetCode
 *
 * Approach (Graphs):
 * 1. Use a priority queue to store the points.
 * 2. Use a loop to iterate through the points and store the points in the priority queue.
 * 3. Return the minimum cost to connect all points.
 */
/**
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a priority queue to store the points.
 * 2. We use a loop to iterate through the points and store the points in the priority queue.
 * 3. We return the minimum cost to connect all points.
 */
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // {cost, index}
        pq.offer(new int[]{0, 0});

        int cost = 0;
        int count = 0;

        while (count < n) {
            int[] curr = pq.poll();
            int currCost = curr[0];
            int i = curr[1];

            if (visited[i]) continue;

            visited[i] = true;
            cost += currCost;
            count++;

            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    int dist = Math.abs(points[i][0] - points[j][0]) +
                               Math.abs(points[i][1] - points[j][1]);
                    pq.offer(new int[]{dist, j});
                }
            }
        }

        return cost;
    }
}