/**
 * Problem: Find Minimum in Rotated Sorted Array II
 * Platform: LeetCode
 *
 * Approach (Binary Search):
 * 1. Use a binary search to find the minimum in the rotated sorted array.
 * 2. Use a loop to iterate through the array and find the minimum.
 * 3. Return the minimum.
 */
/**
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a binary search to find the minimum in the rotated sorted array.
 * 2. We use a loop to iterate through the array and find the minimum.
 * 3. We return the minimum.
 */

class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        int l = 0;
        int r = nums.length-1;
        while (l < r) {
            int m = l + (r-l) / 2;
            if (nums[m] > nums[r]) l = m+1;
            else if (nums[m] > nums[l]) r = m-1;
            else r--;
        }
        return nums[r];
            
    }
}