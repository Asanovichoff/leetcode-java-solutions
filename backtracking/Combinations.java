/**
 * Problem: Combinations
 * Platform: LeetCode
 *
 * Approach (Backtracking):
 * 1. Use a backtracking approach to find the combinations.
 * 2. Use a helper function to find the combinations.
 * 3. Use a loop to iterate through the array and find the combinations.
 * 4. Return the combinations.
 */
/**
 * Time Complexity: O(k * C(n, k))
 * Space Complexity: O(C(n, k))
 * 
 * Explanation:
 * 1. We use a backtracking approach to find the combinations.
 * 2. We use a helper function to find the combinations.
 * 3. We use a loop to iterate through the array and find the combinations.
 * 4. We return the combinations.
 */
class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        if (k > n) return result;
        backTrack(1, n, k, new ArrayList<>());
        return result;
    }

    public void backTrack(int start, int n, int k, List<Integer> combination) {
        if (k == 0) {
            result.add(new ArrayList<>(combination)); 
            return;
        }

        for (int num = start; num <= n - k + 1; num++) {
            combination.add(num);
            backTrack(num + 1, n, k - 1, combination);
            combination.remove(combination.size() - 1);
        }
    }
}
