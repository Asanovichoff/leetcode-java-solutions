/**
 * Problem: Predict the Winner
 * Platform: LeetCode
 *
 * Intuition:
 * 1. The player can choose the left or right side of the array.
 * 2. Both players play optimally, so each tries to maximize their own score while minimizing the opponent’s advantage.
 * 3. Instead of tracking both players’ scores separately, define a function:
 *    f(l, r) = the maximum score the current player can achieve from the subarray nums[l:r]
 *    The current player can choose either nums[l] or nums[r], and the opponent will play optimally as well.
 *    Therefore, the current player’s score will be:
 *    nums[l] - f(l+1, r) or nums[r] - f(l, r-1)
 *    The current player will choose the option that maximizes their score.
 *    The base case is when l > r, the score is 0.
 *    The memoization array is used to store the results of the subproblems.
 *    The seen array is used to store the results of the subproblems.
 *    The dfs function is used to recursively calculate the result.
 *    The result is the maximum score the current player can achieve from the subarray nums[0:nums.length-1].
 *    If the result is greater than 0, the current player can win.
 *    Otherwise, the current player can not win.
 * 
 * 
 * Approach (Dynamic Programming):
 * 1. Use a memoization array to store the results of the subproblems.
 * 2. Use a seen array to store the results of the subproblems.
 * 3. Use a dfs function to recursively calculate the result.
 * 4. Return the result.
 * 
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 */

class Solution {
    int[][] memo = new int[20][20];
    boolean[][] seen = new boolean[20][20];
    public boolean predictTheWinner(int[] nums) {
        if(nums.length<3) return true;
        return dfs(0,nums.length-1, nums)>=0;
        
    }
    public int dfs(int l, int r, int[] nums){
        if(l>r) return 0;
        if(seen[l][r]!=false) return memo[l][r];
        else{
            memo[l][r] = Math.max(nums[l]-dfs(l+1, r, nums), nums[r]-dfs(l, r-1, nums));
            seen[l][r] = true;
        }
        return memo[l][r];
    }
}
