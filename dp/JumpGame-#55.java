/**
 * Problem: Jump Game
 * Platform: LeetCode
 *
 * Approach (Dynamic Programming):
 * 1. Use a pointer to keep track of the maximum jump range.
 * 2. Use a loop to iterate through the array and find the maximum jump range.
 * 3. Update the pointer to the maximum jump range.
 * 4. If the pointer is at the last index, return true.
 * 5. Otherwise, return false.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Idea:
	•	maxJump represents the minimum number of steps needed to reach the end from the current position.
	•	Start from the second-to-last index and move backward.

How it works:
	•	If nums[i] >= maxJump, the current index can reach a “good” position (one that can reach the end), so reset maxJump to 1.
	•	Otherwise, this index cannot reach a good position directly, so increase maxJump by 1.
	•	After processing all indices, if maxJump == 1, the start position can reach the end.
 */
class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1) return true;
        int maxJump = 1;
        for(int i = nums.length-2; i>=0; i--){
            if(nums[i]>=maxJump){
                maxJump = 1;
            }else{
                maxJump++;
            }
        }
        return maxJump==1;
    }
}