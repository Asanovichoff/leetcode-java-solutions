/**
 * Problem: Search in Rotated Sorted Array
 * Platform: LeetCode
 *
 * Approach (Binary Search):
 * 1. Use a binary search to find the target in the rotated sorted array.
 * 2. Use a loop to iterate through the array and find the target.
 * 3. Return the index of the target.
 */

/**
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a binary search to find the target in the rotated sorted array.
 * 2. We use a loop to iterate through the array and find the target.
 * 3. We return the index of the target.
 */
class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } 
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }
}