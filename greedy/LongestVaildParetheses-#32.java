/**
 * Problem: Longest Valid Parentheses
 * Platform: LeetCode
 *
 * Approach (Two-pass):
 * 1. Use a left and right pointer to keep track of the number of left and right parentheses.
 * 2. Use a loop to iterate through the string and count the number of left and right parentheses.
 * 3. If the number of right parentheses is greater than the number of left parentheses, reset the left and right pointers.
 * 4. If the number of left parentheses is equal to the number of right parentheses, update the maximum length.
 */

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a left and right pointer to keep track of the number of left and right parentheses.
 * 2. We use a loop to iterate through the string and count the number of left and right parentheses.
 * 3. If the number of right parentheses is greater than the number of left parentheses, reset the left and right pointers.
 * 4. If the number of left parentheses is equal to the number of right parentheses, update the maximum length.
 * 
 * 
 */
class Solution {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxLen = 0;
        // Left to Right
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') left++;
            else right++;

            if (right > left) {
                left = right = 0;
            } else if (left == right) {
                maxLen = Math.max(maxLen, 2 * right);
            }
        }
        // Right to Left
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') right++;
            else left++;

            if (left > right) {
                left = right = 0;
            } else if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            }
        }

        return maxLen;
    }
}

