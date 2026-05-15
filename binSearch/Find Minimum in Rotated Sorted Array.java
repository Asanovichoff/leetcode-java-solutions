/**
 * Problem: Find Minimum in Rotated Sorted Array
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
        if(nums.length == 1) return nums[0];
        int l = 0;
        int r = nums.length-1;

        while(r-l !=1){
            int m = (r+l)/2;
            if (nums[l]<nums[r]){
                if(nums[l]>nums[m]){
                    l = m;
                }else if(nums[l]<nums[m]){
                    r = m;
                }    
            }else if(nums[l]>nums[r]){
                if(nums[l]>nums[m]){
                    r = m;
                }else if(nums[l]<nums[m]){
                    l = m;
                }    
            }
        }
        if(nums[l]<nums[r]){
            return nums[l];
        }else{
            return nums[r];
        }
        
    }
}