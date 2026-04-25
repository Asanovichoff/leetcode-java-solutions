/**
 * Problem: Subarray Product Less Than K
 * Platform: LeetCode
 *
 * Approach (Sliding Window):
 * 1. Use a sliding window to find the subarray product less than k.
 * 2. Use a loop to iterate through the array and find the subarray product less than k.
 * 3. Return the result.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
/**
 * Explanation:
 * 1. We use a sliding window to find the subarray product less than k.
 * 2. We use a loop to iterate through the array and find the subarray product less than k.
 * 3. We return the result.
 */
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int left = 0;
        int product = 1;
        int result = 0;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            while (product >= k) {
                product /= nums[left];
                left++;
            }

            result += right - left + 1;
        }

        return result;
    }
}