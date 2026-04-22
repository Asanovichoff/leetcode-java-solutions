/**
 * Problem: Continuous Subarray Sum
 * Platform: LeetCode
 *
 * Approach (Prefix Sum):
 * 1. Use a map to store the sum and the index of the first occurrence of the sum.
 * 2. Use a loop to iterate through the array and store the sum and the index of the first occurrence of the sum.
 * 3. If the sum is divisible by k, return true.
 * 4. If the sum is not divisible by k, return false.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a map to store the sum and the index of the first occurrence of the sum.
 * 2. We use a loop to iterate through the array and store the sum and the index of the first occurrence of the sum.
 * 3. If the sum is divisible by k, return true.
 * 4. If the sum is not divisible by k, return false.
 */
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); 
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = sum % k;

            if (map.containsKey(mod)) {
                if (i - map.get(mod) > 1) {
                    return true;
                }
            } else {
                map.put(mod, i);
            }
        }
        return false;
    }
}
