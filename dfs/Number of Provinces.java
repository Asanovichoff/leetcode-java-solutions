/**
 * Problem: Number of Provinces
 * Platform: LeetCode
 * Approach :
 * 1. We can solve this problem using a depth-first search (DFS) traversal of the graph represented by the adjacency matrix `isConnected`.
 * 2. We will maintain a boolean array `visited` to keep track of the cities that have already been visited during the DFS traversal.
 * 3. We will iterate through each city, and if it has not been visited, we will initiate a DFS traversal from that city to mark all the cities that are connected to it as visited.
 * 4. Each time we initiate a DFS traversal from an unvisited city, we will increment the count of provinces.
 * 5. Finally, we will return the count of provinces as the result.
 */
/**
 * Time Complexity: O(n^2), where n is the number of cities, as we may need to visit each city and check its connections with all other cities.
 * Space Complexity: O(n), where n is the number of cities, which is the space required for the `visited` array and the recursion stack during the DFS traversal.
 */

class Solution {
    private boolean[] visited;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        visited = new boolean[n];

        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, isConnected);
                provinces++;
            }
        }
        return provinces;
    }

    private void dfs(int city, int[][] isConnected) {
        visited[city] = true;

        for (int neighbor = 0; neighbor < isConnected.length; neighbor++) {
            if (isConnected[city][neighbor] == 1 && !visited[neighbor]) {
                dfs(neighbor, isConnected);
            }
        }
    }
}