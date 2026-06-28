/**
 * Problem: Maximum Element After Decreasing and Rearranging
 * Platform: LeetCode
 *
 * Approach (Sorting):
 * 1. Use a sorting approach to find the maximum element after decreasing and rearranging the array.
 * 2. Use a loop to iterate through the array and find the maximum element after decreasing and rearranging the array.
 * 3. Return the maximum element after decreasing and rearranging the array.
 */
/**
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a sorting approach to find the maximum element after decreasing and rearranging the array.
 * 2. We use a loop to iterate through the array and find the maximum element after decreasing and rearranging the array.
 * 3. We return the maximum element after decreasing and rearranging the array.
 */
class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i< arr.length; i++) {
            if (arr[i]-1 <= arr[i-1]) continue;
            arr[i] = arr[i-1] + 1;
        }
        return arr[arr.length-1];
    }
}
