/**
 * Problem: Maximum Total Subarray Value I
 * Platform: LeetCode
 *
 * Approach (Two Pointers):
 * 1. Use two pointers to find the maximum total subarray value.
 * 2. Use a loop to iterate through the array and find the maximum total subarray value.
 * 3. Return the maximum total subarray value.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use two pointers to find the maximum total subarray value.
 * 2. We use a loop to iterate through the array and find the maximum total subarray value.
 * 3. We return the maximum total subarray value.
 */
class Solution {
    public long maxTotalValue(int[] nums, int k) {
        if (nums.length == 1) return 0;
        int minNum = nums[0];
        int maxNum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxNum) maxNum = nums[i];
            if (nums[i] < minNum) minNum = nums[i];
        }
        return (long)(maxNum-minNum) * k;
    }
}
