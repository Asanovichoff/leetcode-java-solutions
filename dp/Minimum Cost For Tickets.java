/**
 * Problem: Minimum Cost For Tickets
 * Platform: LeetCode
 *
 * Approach (Dynamic Programming):
 * 1. Use a dynamic programming approach to find the minimum cost for tickets.
 * 2. Use a loop to iterate through the array and find the minimum cost for tickets.
 * 3. Return the minimum cost for tickets.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)

/**
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a dynamic programming approach to find the minimum cost for tickets.
 * 2. We use a loop to iterate through the array and find the minimum cost for tickets.
 * 3. We return the minimum cost for tickets.
 */
class Solution {
    private int[] days;
    private int[] costs;
    private Integer[] memo;

    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        memo = new Integer[days.length];
        return dfs(0);
    }

    private int dfs(int idx) {
        if (idx >= days.length) {
            return 0;
        }
        if (memo[idx] != null) {
            return memo[idx];
        }
        int oneDay = costs[0] + dfs(idx + 1);

        int j = idx;
        while (j < days.length &&
               days[j] <= days[idx] + 6) {
            j++;
        }
        int sevenDay = costs[1] + dfs(j);

        j = idx;
        while (j < days.length &&
               days[j] <= days[idx] + 29) {
            j++;
        }
        int thirtyDay = costs[2] + dfs(j);

        memo[idx] = Math.min(oneDay,
                    Math.min(sevenDay, thirtyDay));

        return memo[idx];
    }
}
