/**
class Solution {
 * Problem: Remove Duplicates from Sorted Array II
 * Platform: LeetCode
 *
 * Approach (Two Pointers):
 * 1. Use a two pointers to keep track of the current index.
 * 2. Use a loop to iterate through the array and remove the duplicates.
 * 3. Return the new length of the array.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a two pointers to keep track of the current index.
 * 2. We use a loop to iterate through the array and remove the duplicates.
 * 3. We return the new length of the array.
 */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int n: nums) {
            if(i < 2 || n > nums[i-2]) {
                nums[i] = n;
                i++;
            }
        }
        return i;
    }
}
