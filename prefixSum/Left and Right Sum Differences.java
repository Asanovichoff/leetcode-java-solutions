/**
 * Problem: Left and Right Sum Differences
 * Platform: LeetCode
 *
 * Approach (Prefix Sum):
 * 1. Use a prefix sum to calculate the left and right sum differences.
 * 2. Use a loop to iterate through the array and calculate the left and right sum differences.
 * 3. Return the left and right sum differences.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a prefix sum to calculate the left and right sum differences.
 * 2. We use a loop to iterate through the array and calculate the left and right sum differences.
 * 3. We return the left and right sum differences.
 */
class Solution {
    public int[] leftRightDifference(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        int[] result = new int[nums.length];
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < result.length; i++) {
            if (i == 0) leftSum = 0;
            else leftSum = nums[i-1];
            if (i == result.length-1) rightSum = 0;
            else rightSum = nums[nums.length-1]-nums[i];

            result[i] = Math.abs(leftSum-rightSum);
        }
        return result;
    }
}