/**
 * problem: https://leetcode.com/problems/minimum-number-of-coins-for-fruits/
 * approach: dp
 * 1. We can solve this problem using a dynamic programming approach.
 * 2. We will maintain a reference to the input array `prices` and define a recursive function `dfs(i)` that computes the minimum number of coins needed to buy all fruits starting from index `i`.
 * 3. In each call to `dfs`, we will consider the cost of buying the fruit at index `i` and recursively compute the minimum number of coins needed for the remaining fruits starting from index `j`, where `j` is in the range `[i + 1, min(n, 2 * i + 2)]`.
 * 4. We will keep track of the minimum number of coins needed for all possible choices of `j` and return the minimum value.
 */
/**
 * Time Complexity: O(n^2), where n is the number of elements in the input array `prices`, as we may need to explore up to n elements for each index during the recursive calls.
 * Space Complexity: O(n), where n is the number of elements in the input array `prices`, which is the space required for the recursion stack and the memoization array.
 */
class Solution {
    private int[] prices;
    private int[] memo;

    public int minimumCoins(int[] prices) {
        this.prices = prices;
        this.memo = new int[prices.length];
        Arrays.fill(memo, -1);
        return dfs(0);
    }

    private int dfs(int i) {
        if (i >= prices.length) return 0;
        if (memo[i] != -1) return memo[i];

        int n = prices.length;
        int cost = prices[i];
        int end = Math.min(n, 2 * i + 2);
        int minFuture = Integer.MAX_VALUE;

        for (int j = i + 1; j <= end; j++) {
            minFuture = Math.min(minFuture, dfs(j));
        }
        memo[i] = cost + minFuture;
        return memo[i];
    }
}