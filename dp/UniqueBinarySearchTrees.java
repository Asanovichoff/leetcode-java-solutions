/**
 * Problem: Unique Binary Search Trees
 * Platform: LeetCode
 *
 * Approach (Dynamic Programming):
 * 1. Use a dynamic programming approach to calculate the number of unique binary search trees.
 * 2. Use a loop to iterate through the array and calculate the number of unique binary search trees.
 * 3. Return the number of unique binary search trees.
 */
/**
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a dynamic programming approach to calculate the number of unique binary search trees.
 * 2. We use a loop to iterate through the array and calculate the number of unique binary search trees.
 * 3. We return the number of unique binary search trees.
 */

class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i<=n; i++){
            int total = 0;
            for(int j = 1; j<=i; j++){
                int left = j-1;
                int right = i-j;
                total+=dp[left]*dp[right];
            }
            dp[i] = total;
        }
        return dp[n];
    }
}
