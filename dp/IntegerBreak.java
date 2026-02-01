/**
 * Problem: Integer Break
 * Platform: LeetCode
 *
 * Approach (Dynamic Programming):
 * 1. Use a dynamic programming array to keep track of the maximum product for each number.
 * 2. For each number, we iterate through all the numbers less than it and calculate the maximum product.
 * 3. We return the maximum product for the given number.
 */
/**
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int num = 2; num <= n; num++) {
            for (int i = 1; i < num; i++) {
                dp[num] = Math.max(
                    dp[num],
                    Math.max(i, dp[i]) * Math.max(num - i, dp[num - i])
                );
            }
        }
        return dp[n];
    }
}