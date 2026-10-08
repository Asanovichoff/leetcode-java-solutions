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
