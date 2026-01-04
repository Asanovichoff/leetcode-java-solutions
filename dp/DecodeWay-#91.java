/**
 * Problem: Decode Way
 * Platform: LeetCode
 *
 * Approach (Dynamic Programming):
 * 1. Use a dynamic programming approach to calculate the number of ways to decode the string.
 * 2. Use a loop to iterate through the string and calculate the number of ways to decode the string.
 * 3. Return the number of ways to decode the string.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a dynamic programming approach to calculate the number of ways to decode the string.
 * 2. We use a loop to iterate through the string and calculate the number of ways to decode the string.
 * 3. We return the number of ways to decode the string.
 */

class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;

        int n = s.length();
        int next = 1;       // dp[i+1]
        int nextNext = 0;   // dp[i+2]
        
        nextNext = 1;

        for (int i = n - 1; i >= 0; i--) {
            int current = 0;

            // Single digit decode
            if (s.charAt(i) != '0') {
                current = next;
            }

            // Two digit decode
            if (i + 1 < n &&
                (s.charAt(i) == '1' ||
                (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))) {
                current += nextNext;
            }

            nextNext = next;
            next = current;
        }

        return next;
    }
}
