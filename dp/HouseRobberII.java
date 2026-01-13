/**
 * Problem: House Robber II
 * Platform: LeetCode
 * 
 * Approach (Dynamic Programming):
 * 1. Use a dynamic programming array to store the maximum amount of money that can be robbed for each index.
 * 2. Use a nested loop to iterate through the array and find the maximum amount of money that can be robbed for each index.
 * 3. Return the maximum amount of money that can be robbed.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a dynamic programming array to store the maximum amount of money that can be robbed for each index.
 * 2. We use a nested loop to iterate through the array and find the maximum amount of money that can be robbed for each index.
 * 3. We return the maximum amount of money that can be robbed.
 */
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        return Math.max(
            robRange(nums, 0, n - 2),
            robRange(nums, 1, n - 1)
        );
    }

    private int robRange(int[] nums, int start, int end) {
        int prev2 = 0; 
        int prev1 = 0; 

        for (int i = start; i <= end; i++) {
            int curr = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}
