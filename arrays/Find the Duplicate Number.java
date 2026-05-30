/**
 * Problem: Find the Duplicate Number
 * Platform: LeetCode
 *
 * Approach (Two Pointers):
 * 1. Use two pointers to find the duplicate number.
 * 2. Use a loop to iterate through the array and find the duplicate number.
 * 3. Return the duplicate number.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use two pointers to find the duplicate number.
 * 2. We use a loop to iterate through the array and find the duplicate number.
 * 3. We return the duplicate number.
 */
class Solution {

    public int findDuplicate(int[] nums) {
        if(nums.length <=2) return nums[0];
        int fast = 0;
        int slow = 0;
        while(true){
            fast= nums[fast];
            fast = nums[fast];
            slow = nums[slow];
            if(fast == slow) break;
        }
        fast = 0;
        while(fast!=slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
        
    }
}