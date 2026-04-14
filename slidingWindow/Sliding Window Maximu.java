/**
 * Problem: Sliding Window Maximum
 * Platform: LeetCode
 *
 * Approach (Sliding Window):
 * 1. Use a sliding window to keep track of the maximum number in the window.
 * 2. Use a loop to iterate through the array and keep track of the maximum number in the window.
 * 3. Return the result.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(k)

/**
 * Time Complexity: O(n)
 * Space Complexity: O(k)
 * 
 * Explanation:
 * 1. We use a sliding window to keep track of the maximum number in the window.
 * 2. We use a loop to iterate through the array and keep track of the maximum number in the window.
 * 3. We return the result.
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length-k+1];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int j = 0; j<k-1; j++) {
            map.put(nums[j], map.getOrDefault(nums[j], 0)+1);
        }
        for (int i = 0; i < result.length; i++) {
            map.put(nums[i+k-1], map.getOrDefault(nums[i+k-1], 0)+1);
            int maxNum = map.lastKey();
            result[i] = maxNum;
            map.put(nums[i], map.get(nums[i])-1);
            if(map.get(nums[i]) == 0){
                map.remove(nums[i]);
            }
        }
        return result;
    }
}