/**
 * Problem: Minimum Cost of Buying Candies With Discount
 * Platform: LeetCode
 *
 * Approach (Sorting):
 * 1. Sort the array in descending order.
 * 2. Use a loop to iterate through the array and buy the candies with the discount.
 * 3. Return the minimum cost of buying the candies.
 */
/**
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We sort the array in descending order.
 * 2. We use a loop to iterate through the array and buy the candies with the discount.
 * 3. We return the minimum cost of buying the candies.
 */
class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int bought = 0;
        int minCost = 0;
        for (int i = cost.length-1; i >= 0; i--) {
            if (bought == 2) {
                bought = 0;
                continue;
            }
            minCost+= cost[i];
            bought++;
        }
        return minCost;
    }
}