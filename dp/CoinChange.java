/**
 * Problem: Coin Change
 * Platform: LeetCode
 *
 * Approach (Dynamic Programming):
 * 1. Use a memoization array to store the minimum number of coins needed to make the amount.
 * 2. Use a loop to iterate through the array and calculate the minimum number of coins needed to make the amount.
 * 3. Return the minimum number of coins needed to make the amount.
 */
/**
 * Time Complexity: O(n * amount)
 * Space Complexity: O(amount)
 * 
 * Explanation:
 * 1. We use a memoization array to store the minimum number of coins needed to make the amount.
 * 2. We use a loop to iterate through the array and calculate the minimum number of coins needed to make the amount.
 * 3. We return the minimum number of coins needed to make the amount.
 */

class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[] memo = new Integer[amount + 1];
        Arrays.fill(memo, amount + 1);
        memo[0] = 0;
        for(int a = 1; a<=amount;a++){
            for(int c: coins){
                if (a-c>=0){
                    memo[a] = Math.min(memo[a],1+memo[a-c]);
                }
            }
        }
        return memo[amount] > amount ? -1 : memo[amount];
    }
}
