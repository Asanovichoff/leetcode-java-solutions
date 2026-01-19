/**
 * Problem: Interleaving String
 * Platform: LeetCode
 *
 * Approach (Dynamic Programming):
 * 1. Use a memoization array to store the results of the subproblems.
 * 2. Use a DFS approach to explore all possible combinations of the strings.
 * 3. If the current index is the end of both strings, return true.
 * 4. If the current index is the end of one string, return false.
 * 5. If the current index is the end of both strings, return true.
 */
/**
 * Time Complexity: O(m*n)
 * Space Complexity: O(m*n)
 */
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length()) return false;
        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];
        return dfs(dp,0,0,s1, s2, s3);
    }
    private boolean dfs(Boolean[][] dp, int i, int j, String s1, String s2, String s3){
        if(i==s1.length() && j== s2.length()) return true;
        if(dp[i][j]!= null) return dp[i][j];
        if(i<s1.length()&& s1.charAt(i)== s3.charAt(i+j) && dfs(dp,i+1,j,s1, s2, s3)) return true;
        if(j<s2.length()&& s2.charAt(j)== s3.charAt(i+j) && dfs(dp,i,j+1,s1, s2, s3)) return true;
        dp[i][j]=false;
        return false;
    }
}