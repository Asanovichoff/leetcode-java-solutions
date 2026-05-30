/**
 * Problem: First Missing Positive
 * Platform: LeetCode
 *
 * Approach (Two Pointers):
 * 1. Use two pointers to find the first missing positive.
 * 2. Use a loop to iterate through the array and find the first missing positive.
 * 3. Return the first missing positive.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use two pointers to find the first missing positive.
 * 2. We use a loop to iterate through the array and find the first missing positive.
 * 3. We return the first missing positive.
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == -1) nums[j] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) continue;
            int fast = nums[i];
            while (fast > 0 && fast <= nums.length) {
                int idx = nums[fast-1];
                nums[fast-1] = -1;
                fast = idx;
            }
        }

        for (int t = 0; t < nums.length; t++) {
            if (nums[t] != -1) return t+1;
        }
        return nums.length+1;
    }

    //[3,4,5,1] len = 4
    //       i    
    // j = nums[i]-1
    //[-1,-1,5,-1]
    // j = 2
    // j = nums[j-1]
    // j = 4;
    // j = nums[j-1]
    //j = 1;
    // j = nums[j-1]
    //j = 0
     //[-1,-1,5,-1]
}