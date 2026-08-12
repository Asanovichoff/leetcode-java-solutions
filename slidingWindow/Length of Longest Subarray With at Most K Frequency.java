/** problem: Length of Longest Subarray With at Most K Frequency
 * 
 * approach 1: brute force
 * time complexity: O(n)
 * space complexity: O(n)
 * 
 * explanation:
 * 1. use a map to store the frequency of the numbers
 * 2. use a pointer to iterate through the array
 * 3. if the frequency of the number is greater than k, then remove the number from the map
 * 4. return the result
 */

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int res = 0, l = 0, r = 0, size = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (r < nums.length) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) +1);
            size++;
            if (map.get(nums[r]) > k) {
                while (l < r && nums[l] != nums[r]) {
                    map.put(nums[l], map.get(nums[l]) -1);
                    size--;
                    l++;
                }
                map.put(nums[l], map.get(nums[l])-1);
                size--;
                l++;
            }
            res = Math.max(res, size);
            r++;

        }
        return res;
    }
}