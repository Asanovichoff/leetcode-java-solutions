/** problem: Predict the Winner
 * 
 * approach 1: dfs
 * time complexity: O(n^2)
 * space complexity: O(n^2)
 * 
 * explanation:
 * 1. use a memoization table to store the results of the subproblems
 * 2. use a boolean array to store the results of the subproblems
 * 3. return the result
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