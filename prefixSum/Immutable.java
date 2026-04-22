/**
 * Problem: Immutable Array
 * Platform: LeetCode
 *
 * Approach (Prefix Sum):
 * 1. Use a prefix array to store the sum of the elements up to the current index.
 * 2. Use a loop to iterate through the array and store the sum of the elements up to the current index.
 * 3. Return the sum of the elements between the left and right indices.
 * 
 * Time Complexity: O(1)
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a prefix array to store the sum of the elements up to the current index.
 * 2. We use a loop to iterate through the array and store the sum of the elements up to the current index.
 * 3. We return the sum of the elements between the left and right indices.
 */

class NumArray {
    int[] prefix;
    public NumArray(int[] nums) {
        prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i-1]+nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return (left == 0) ? prefix[right] : prefix[right]-prefix[left-1];
    }
}