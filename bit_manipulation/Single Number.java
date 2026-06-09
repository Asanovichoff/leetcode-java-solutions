/**
 * Problem: Single Number
 * Platform: LeetCode
 *
 * Approach (Bit Manipulation):
 * 1. Use a bit manipulation to find the single number.
 * 2. Use a loop to iterate through the array and find the single number.
 * 3. Return the single number.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a bit manipulation to find the single number.
 * 2. We use a loop to iterate through the array and find the single number.
 * 3. We return the single number.
 */
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num : nums){
            res ^=num;
        }
        return res;
    }
}
