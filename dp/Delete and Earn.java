/**
 * Problem: Delete and Earn
 * Platform: LeetCode
 *
 * Approach (Dynamic Programming):
 * 1. Use a dynamic programming approach to find the maximum amount of money that can be earned.
 * 2. Use a loop to iterate through the array and find the maximum amount of money that can be earned.
 * 3. Return the maximum amount of money that can be earned.
 */
/**
 * Time Complexity: O(n log n)

/**
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a dynamic programming approach to find the maximum amount of money that can be earned.
 * 2. We use a loop to iterate through the array and find the maximum amount of money that can be earned.
 * 3. We return the maximum amount of money that can be earned.
 */
class Solution {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int dp1 = 0;
        int dp2 = 0; 
        int prev = -1;
        int i = 0;

        while (i < nums.length) {
            int current = nums[i];
            int sum = 0;
            while (i < nums.length && nums[i] == current) {
                sum += nums[i];
                i++;
            }
            int temp = 0;
            if (current == prev + 1) {
                temp = Math.max(dp2, dp1 + sum);
            }else {
                temp = dp2 + sum;
            }
            dp1 = dp2;
            dp2 = temp;
            prev = current;
        }
        return dp2;
    }
}
