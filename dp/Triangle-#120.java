/**
 * Problem: Triangle
 * Platform: LeetCode
 *
 * Approach (Dynamic Programming):
 * 1. Use a dynamic programming approach to calculate the minimum path sum.
 * 2. Use a loop to iterate through the array and calculate the minimum path sum.
 * 3. Return the minimum path sum.
 */
/**
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a dynamic programming approach to calculate the minimum path sum.
 * 2. We use a loop to iterate through the array and calculate the minimum path sum.
 * 3. We return the minimum path sum.
 */

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // lastRow
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        // bottom up
        for (int r = n - 2; r >= 0; r--) {
            for (int i = 0; i <= r; i++) {
                dp[i] = triangle.get(r).get(i)
                        + Math.min(dp[i], dp[i + 1]);
            }
        }

        return dp[0];
    }
}
