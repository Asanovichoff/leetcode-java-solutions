/**
 * Problem: Pascal's Triangle II
 * Platform: LeetCode
 *
 * Approach (Dynamic Programming):
 * 1. Use a dynamic programming array to keep track of the previous row.
 * 2. Use a loop to iterate through the array and update the dynamic programming array.
 * 3. Return the dynamic programming array.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> dp = new ArrayList<>(Collections.nCopies(rowIndex + 1, 0));
        dp.set(0, 1);

        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                dp.set(j, dp.get(j) + dp.get(j - 1));
            }
        }
        return dp;
    }
}