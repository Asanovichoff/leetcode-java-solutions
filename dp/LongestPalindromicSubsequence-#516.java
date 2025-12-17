/**
 * Problem: Longest Palindromic Subsequence
 * Platform: LeetCode
 * 
 * Implement Longest Palindromic Subsequence using LCS with DP optimization
 *
 * Approach (Dynamic Programming):
 * 1. Reverse the input string.
 * 2. Use the longestCommonSubsequence function to find the longest common subsequence between the input string and the reversed string.
 * 3. The result is the length of the longest common subsequence.
 * 
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We reverse the input string.
 * 2. We use the longestCommonSubsequence function to find the longest common subsequence between the input string and the reversed string.
 * 3. The result is the length of the longest common subsequence.
 * 
 * 
 * 
 */



class Solution {
    public int longestPalindromeSubseq(String s) {
        String reversedS = new StringBuilder(s).reverse().toString();
        return longestCommonSubsequence(s,reversedS);
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[] next = new int[text2.length() + 1];
        int[] curr = new int[text2.length() + 1];
        
        for (int i = text1.length() - 1; i >= 0; i--) {
            for (int j = text2.length() - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    curr[j] = 1 + next[j + 1];
                } else {
                    curr[j] = Math.max(next[j], curr[j + 1]);
                }
            }
            next = curr.clone(); // move current row up
        }
        
        return next[0];
    }
}