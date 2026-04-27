/**
 * Problem: Two City Scheduling
 * Platform: LeetCode
 *
 * Approach (Greedy):
 * 1. Use a greedy approach to find the minimum cost to schedule the two cities.
 * 2. Use a loop to iterate through the costs and find the minimum cost to schedule the two cities.
 * 3. Return the result.
 */
/**
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 */
/**
 * Explanation:
 * 1. We use a greedy approach to find the minimum cost to schedule the two cities.
 * 2. We use a loop to iterate through the costs and find the minimum cost to schedule the two cities.
 * 3. We return the result.
 */
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));

        int total = 0;
        int n = costs.length / 2;

        for (int i = 0; i < n; i++) {
            total += costs[i][0]; // City A
        }

        for (int i = n; i < costs.length; i++) {
            total += costs[i][1]; // City B
        }

        return total;
    }
}