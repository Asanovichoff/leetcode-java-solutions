/**
 * Problem: Number of Longest Increasing Subsequence
 * Platform: LeetCode
 *
 * Approach (Dynamic Programming):
 * 1. Use a dynamic programming approach to find the number of longest increasing subsequence.
 * 2. Use a loop to iterate through the array and find the number of longest increasing subsequence.
 * 3. Return the number of longest increasing subsequence.
 */
/**
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a dynamic programming approach to find the number of longest increasing subsequence.
 * 2. We use a loop to iterate through the array and find the number of longest increasing subsequence.
 * 3. We return the number of longest increasing subsequence.
 */
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] len = new int[n];
        int[] count = new int[n];
        Arrays.fill(len, 1);
        Arrays.fill(count, 1);
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (len[j] + 1 > len[i]) {
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    }
                    else if (len[j] + 1 == len[i]) {
                        count[i] += count[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, len[i]);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (len[i] == maxLen) {
                result += count[i];
            }
        }

        return result;
    }
}
