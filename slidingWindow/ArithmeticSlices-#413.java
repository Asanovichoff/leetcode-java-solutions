/**
 * Problem: Arithmetic Slices
 * Platform: LeetCode
 *
 * Approach (Sliding Window):
 * 1. Use a sliding window to find the number of arithmetic slices.
 * 2. Use a pointer to keep track of the left and right indices of the window.
 * 3. Use a diff variable to keep track of the difference between the two indices.
 * 4. Use a loop to iterate through the array and find the number of arithmetic slices.
 * 5. Return the number of arithmetic slices.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a sliding window to find the number of arithmetic slices.
 * 2. We use a pointer to keep track of the left and right indices of the window.
 * 3. We use a diff variable to keep track of the difference between the two indices.
 * 4. We use a loop to iterate through the array and find the number of arithmetic slices.
 * 5. We return the number of arithmetic slices.
 */
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
    // len >= 3;
    // diff == always;
        int subArrCount = 0;
        if(nums.length<3) return 0;
        int l = 0; int r = 1;
        int diff = nums[r]-nums[l];
        while(r<nums.length){
            if(nums[r]-nums[r-1]== diff){
                r++;
            }else{
                int size = r-l;
                if(size>=3){
                    subArrCount  += (size-2)*(size-1)/2;
                }
                l = r-1;
                diff = nums[r]-nums[r-1];
            }
        }
        int size = r-l;
        if(size>=3){
            subArrCount  += (size-2)*(size-1)/2;
        }
        return subArrCount;
    }
}
