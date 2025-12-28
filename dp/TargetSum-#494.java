/**
 * Problem: Target Sum
 * Platform: LeetCode
 *
 * Approach (Dynamic Programming):
 * 1. Use a memoization array to store the number of ways to reach the current step.
 * 2. Use a loop to iterate through the array and calculate the number of ways to reach the current step.
 * 3. Return the number of ways to reach the last step.
 */
/**
 * Time Complexity: O(n * target)
 * Space Complexity: O(n * target)
 * 
 * Explanation:
 * 1. We use a memoization array to store the number of ways to reach the current step.
 * 2. We use a loop to iterate through the array and calculate the number of ways to reach the current step.
 * 3. We return the number of ways to reach the last step.
 */

class Solution {
    Map<String, Integer> memo = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0, 0);
    }
    public int dfs(int[] nums, int target, int idx, int sum) {
        if (idx == nums.length) {
            return sum == target ? 1 : 0;
        }

        String key = idx + "," + sum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int add = dfs(nums, target, idx + 1, sum + nums[idx]);
        int subtract = dfs(nums, target, idx + 1, sum - nums[idx]);

        memo.put(key, add + subtract);
        return memo.get(key);
    }
}