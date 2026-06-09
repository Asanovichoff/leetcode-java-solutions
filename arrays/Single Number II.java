/**
 * Problem: Single Number II
 * Platform: LeetCode
 *
 * Approach (Sorting):
 * 1. Use a sorting algorithm to find the single number.
 * 2. Use a loop to iterate through the array and find the single number.
 * 3. Return the single number.
 */
/**
 * Time Complexity: O(n log n)

/**
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a sorting algorithm to find the single number.
 * 2. We use a loop to iterate through the array and find the single number.
 * 3. We return the single number.
 */
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i<nums.length-1; i+=3){
            if(nums[i]!=nums[i-1]) return nums[i-1];
        }
        return nums[nums.length-1];
    }
}
