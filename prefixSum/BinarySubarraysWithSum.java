/**
 * Problem: Binary Subarrays With Sum
 * Platform: LeetCode
 *
 * Approach (Prefix Sum):
 * 1. Use a map to store the prefix sum and the number of times it appears.
 * 2. Use a loop to iterate through the array and calculate the prefix sum.
 * 3. Use the map to store the prefix sum and the number of times it appears.
 * 4. Return the result.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a map to store the prefix sum and the number of times it appears.
 * 2. We use a loop to iterate through the array and calculate the prefix sum.
 * 3. We use the map to store the prefix sum and the number of times it appears.
 * 4. We return the result.
 */
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefixSum = 0;
        int result = 0;

        for (int num : nums) {
            prefixSum += num;

            if (map.containsKey(prefixSum - goal)) {
                result += map.get(prefixSum - goal);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return result;
    }
}