/**
 * Problem: Jump Game II
 * Platform: LeetCode
 *
 * Approach (Dynamic Programming):
 * 1. Use two pointers to keep track of the current and maximum jump range.
 * 2. Use a loop to iterate through the array and find the maximum jump range.
 * 3. Update the left pointer to the right pointer + 1.
 * 4. Update the right pointer to the maximum jump range.
 * 5. Increment the result by 1.
 *
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use two pointers to keep track of the current and maximum jump range.
 * 2. We use a loop to iterate through the array and find the maximum jump range.
 * 3. We update the left pointer to the right pointer + 1.
 * 4. We update the right pointer to the maximum jump range.
 * 5. We increment the result by 1.
 * 
 * 
 * 
 */

class Solution {
    public int jump(int[] nums) {
        int result = 0;
        int l = 0;
        int r = 0;
        while(r<nums.length-1){
            int maxJump = 0;
            for(int i = l; i<=r; i++){
                maxJump = Math.max(maxJump, i+nums[i]);
            }
            l = r+1;
            r = maxJump;
            result++;
        }
        return result;
    }
}