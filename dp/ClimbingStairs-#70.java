/**
 * Problem: Climbing Stairs
 * Platform: LeetCode
 *
 * Approach (Dynamic Programming):
 * 1. Use a memoization array to store the number of ways to reach the current step.
 * 2. Use a loop to iterate through the array and calculate the number of ways to reach the current step.
 * 3. Return the number of ways to reach the last step.
 *
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a memoization array to store the number of ways to reach the current step.
 * 2. We use a loop to iterate through the array and calculate the number of ways to reach the current step.
 * 3. We return the number of ways to reach the last step.
 */
class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climb(n, memo);
    }

    private int climb(int n, int[] memo) {
        if (n <= 1) return 1;

        if (memo[n] > 0) return memo[n];

        memo[n] = climb(n - 1, memo) + climb(n - 2, memo);
        return memo[n];
    }
}