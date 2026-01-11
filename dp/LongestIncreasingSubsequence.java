/**
 * Problem: Longest Increasing Subsequence
 * Platform: LeetCode
 * 
 * Approach (Dynamic Programming):
 * 1. Use a dynamic programming array to store the longest increasing subsequence for each index.
 * 2. Use a nested loop to iterate through the array and find the longest increasing subsequence for each index.
 * 3. Return the longest increasing subsequence.
 * 
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a dynamic programming array to store the longest increasing subsequence for each index.
 * 2. We use a nested loop to iterate through the array and find the longest increasing subsequence for each index.
 * 3. We return the longest increasing subsequence.
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        int res = 0;
        for (int len : dp) {
            res = Math.max(res, len);
        }
        return res;
    }
}
