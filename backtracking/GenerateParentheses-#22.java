/**
 * Problem: Generate Parentheses
 * Platform: LeetCode
 *
 * Approach (Backtracking):
 * 1. Use a backtracking approach to generate all possible combinations of parentheses.
 * 2. Use a helper function to generate the combinations.
 * 3. Use a loop to generate the combinations.
 * 4. Return the result.
 *
 * 
 * Time Complexity: O(2^n)
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a backtracking approach to generate all possible combinations of parentheses.
 * 2. We use a helper function to generate the combinations.
 * 3. We use a loop to generate the combinations.
 * 4. We return the result.
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backTrack(n, n, "", result);
        return result;
    }
    
    public void backTrack(int openBracket, int closeBracket,
                          String combination, List<String> result) {
        if (openBracket == 0 && closeBracket == 0) {
            result.add(combination);
            return;
        }
        if (openBracket > 0) {
            backTrack(openBracket - 1, closeBracket, combination + '(', result);
        }
        if (closeBracket > openBracket) {
            backTrack(openBracket, closeBracket - 1, combination + ')', result);
        }
    }
}