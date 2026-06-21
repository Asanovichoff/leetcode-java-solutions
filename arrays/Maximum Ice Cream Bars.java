/**
 * Problem: Maximum Ice Cream Bars
 * Platform: LeetCode
 *
 * Approach (Sorting):
 * 1. Use a sorting approach to find the maximum number of ice cream bars that can be bought.
 * 2. Use a loop to iterate through the costs and find the maximum number of ice cream bars that can be bought.
 * 3. Return the maximum number of ice cream bars that can be bought.
 */
/**
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a sorting approach to find the maximum number of ice cream bars that can be bought.
 * 2. We use a loop to iterate through the costs and find the maximum number of ice cream bars that can be bought.
 * 3. We return the maximum number of ice cream bars that can be bought.
 */
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for (int cost : costs) {
            coins-=cost;
            if (coins >=0) count++;
            else break;
        }
        return count;
    }
}
