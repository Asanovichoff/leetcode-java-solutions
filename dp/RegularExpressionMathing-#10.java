/**
 * Problem: Regular Expression Matching
 * Platform: LeetCode
 *
 * Approach (Dynamic Programming):
 * 1. Use a memoization array to store the results of the subproblems.
 * 2. Use a loop to iterate through the string and pattern and check if the current characters match.
 * 3. If the current characters match, update the memoization array.
 * 4. If the current characters do not match, return false.
 *
 * Idea:
 * 1. Use a memoization array to store the results of the subproblems.
 * 2. Use a loop to iterate through the string and pattern and check if the current characters match.
 * 3. If the current characters match, update the memoization array.
 * 4. If the current characters do not match, return false.
 *
 * How it works:
 * 1. We use a memoization array to store the results of the subproblems.
 * 2. We use a loop to iterate through the string and pattern and check if the current characters match.
 * 3. If the current characters match, update the memoization array.
 * 4. If the current characters do not match, return false.
 *
 * Time Complexity: O(n*m)
 * Space Complexity: O(n*m)
 */
class Solution {
    Boolean[][] memo;

    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(0, 0, s, p);
    }

    private boolean dfs(int i, int j, String s, String p) {
        if (memo[i][j] != null) return memo[i][j];
        // If pattern is exhausted, string must also be exhausted
        if (j == p.length()) {
            return memo[i][j] = (i == s.length());
        }

        // Check if current characters match
        boolean firstMatch = (i < s.length() &&
                (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        boolean result;

        // Handle '*'
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // Two choices:
            // 1) Skip x*
            // 2) Use one char if it matches
            result = dfs(i, j + 2, s, p) ||
                     (firstMatch && dfs(i + 1, j, s, p));
        } else {
            // Normal match
            result = firstMatch && dfs(i + 1, j + 1, s, p);
        }

        memo[i][j] = result;
        return result;
    }
}