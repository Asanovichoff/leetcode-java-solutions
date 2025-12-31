/**
 * Problem: Edit Distance
 * Platform: LeetCode
 *
 * Approach (Dynamic Programming):
 * 1. Use a recursive approach to calculate the minimum number of operations to convert the word1 to word2.
 * 2. Use a memoization array to store the minimum number of operations to convert the word1 to word2.
 * 3. Use a loop to iterate through the array and calculate the minimum number of operations to convert the word1 to word2.
 * 4. Return the minimum number of operations to convert the word1 to word2.
 */
/**
 * Time Complexity: O(n * m)
 * Space Complexity: O(n * m)
 * 
 * Explanation:
 * 1. We use a memoization array to store the minimum number of operations to convert the word1 to word2.
 * 2. We use a loop to iterate through the array and calculate the minimum number of operations to convert the word1 to word2.
 * 3. We return the minimum number of operations to convert the word1 to word2.
 */

class Solution {
    private Integer[][] memo;
    private String word1, word2;

    public int minDistance(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        memo = new Integer[word1.length() + 1][word2.length() + 1];
        return dfs(0, 0);
    }

    private int dfs(int i, int j) {
        if (memo[i][j] != null) return memo[i][j];
        // Base cases
        if (i == word1.length()) {
            return memo[i][j] = word2.length() - j;
        }
        if (j == word2.length()) {
            return memo[i][j] = word1.length() - i;
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            return memo[i][j] = dfs(i + 1, j + 1);
        }
        int replace = 1 + dfs(i + 1, j + 1);
        int insert  = 1 + dfs(i, j + 1);
        int delete  = 1 + dfs(i + 1, j);

        return memo[i][j] = Math.min(replace, Math.min(insert, delete));
    }
}

