/**
 * Problem: House Robber
 * Platform: LeetCode
 *
 * Approach (Dynamic Programming):
 * 1. Use a dynamic programming approach to calculate the maximum amount of money that can be robbed.
 * 2. Use a loop to iterate through the array and calculate the maximum amount of money that can be robbed.
 * 3. Return the maximum amount of money that can be robbed.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a dynamic programming approach to calculate the maximum amount of money that can be robbed.
 * 2. We use a loop to iterate through the array and calculate the maximum amount of money that can be robbed.
 * 3. We return the maximum amount of money that can be robbed.
 */

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int dp1 = 0; int dp2 = 0;
        for(int num:nums){
            int temp = Math.max(num+dp2,dp1);
            dp2 = dp1;
            dp1 = temp;
        }
        return dp1;
    }
}
