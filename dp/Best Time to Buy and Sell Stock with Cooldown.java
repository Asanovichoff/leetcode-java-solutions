/**
 * Problem: Best Time to Buy and Sell Stock with Cooldown
 * Platform: LeetCode
 *
 * Approach (Dynamic Programming):
 * 1. Use a dynamic programming approach to calculate the maximum profit.
 * 2. Use a loop to iterate through the prices and calculate the maximum profit.
 * 3. Return the maximum profit.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a dynamic programming approach to calculate the maximum profit.
 * 2. We use a loop to iterate through the prices and calculate the maximum profit.
 * 3. We return the maximum profit.
 */
class Solution {
    private Integer[][] dp;

    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        dp = new Integer[prices.length][2];
        return dfs(prices, 0, 1);
    }

    public int dfs(int[] prices, int idx, int buying) {
        if (idx >= prices.length) return 0;

        if (dp[idx][buying] != null) return dp[idx][buying];

        int cooldown = dfs(prices, idx + 1, buying);

        if (buying == 1) {
            int buy = dfs(prices, idx + 1, 0) - prices[idx];
            dp[idx][buying] = Math.max(cooldown, buy);
        } else {
            int sell = dfs(prices, idx + 2, 1) + prices[idx];
            dp[idx][buying] = Math.max(cooldown, sell);
        }

        return dp[idx][buying];
    }
}