/**
 * Problem: Smallest Stable Index
 * Platform: LeetCode
 *
 * Approach (Array):
 * 1. Use an array to store the suffix minimum values.
 * 2. Use a loop to iterate through the array and store the suffix minimum values.
 * 3. Return the smallest stable index.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use an array to store the suffix minimum values.
 * 2. We use a loop to iterate through the array and store the suffix minimum values.
 * 3. We return the smallest stable index.
 */
class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int maxNum = nums[0];
        int[] suffixMin = new int[nums.length];
        suffixMin[nums.length-1] = nums[nums.length-1];
        for (int j = nums.length-2; j>=0; j--) {
            suffixMin[j] = Math.min(suffixMin[j+1], nums[j]);
        }
        for (int i = 0; i<nums.length; i++) {
            maxNum = Math.max(maxNum, nums[i]);
            if (maxNum-suffixMin[i] <= k) return i;
        }
        return -1;
    }
}