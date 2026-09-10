/**
 * Problem: Maximum Sum of Two Non-Overlapping Subarrays
 * Platform: LeetCode
 *
 * Approach :
 * 1. We can solve this problem using a prefix sum array to efficiently calculate the sum of subarrays.
 * 2. We will iterate through the array and for each position, we will calculate the maximum sum of the first subarray of length `firstLen` that ends before the current position, and the sum of the second subarray of length `secondLen` that starts at the current position.
 * 3. We will keep track of the maximum sum of the first subarray and update the result with the sum of the first and second subarrays.
 * 4. We will repeat the process by swapping the roles of the two subarrays to ensure we consider both possible orders of the subarrays.
 * 5. Finally, we will return the maximum sum found.
 */
/**
 * Time Complexity: O(n), where n is the length of the input array `nums`, as we are iterating through the array to compute prefix sums and to find the maximum sums of the subarrays. 
 * Space Complexity: O(n), as we are using a prefix sum array of size n + 1 to store the cumulative sums of the input array.
 */

class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        return Math.max(
            solve(nums, firstLen, secondLen),
            solve(nums, secondLen, firstLen)
        );
    }

    private int solve(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;

        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int maxFirst = 0;
        int res = 0;
        for (int i = firstLen; i + secondLen <= n; i++) {
            int firstSum = prefix[i] - prefix[i - firstLen];
            maxFirst = Math.max(maxFirst, firstSum);

            int secondSum = prefix[i + secondLen] - prefix[i];
            res = Math.max(res, maxFirst + secondSum);
        }

        return res;
    }
}