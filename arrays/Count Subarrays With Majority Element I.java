/**
 * Problem: Count Subarrays With Majority Element I
 * Platform: LeetCode
 *
 * Approach (Two Pointers):
 * 1. Use a two pointers approach to count the number of subarrays with the majority element.
 * 2. Use a loop to iterate through the array and count the number of subarrays with the majority element.
 * 3. Return the number of subarrays with the majority element.
 */
/**
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a two pointers approach to count the number of subarrays with the majority element.
 * 2. We use a loop to iterate through the array and count the number of subarrays with the majority element.
 * 3. We return the number of subarrays with the majority element.
 */
class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == target) count++;
                else count--;
                if (count > 0) res++;
            }
        }
        return res;
    } 
}