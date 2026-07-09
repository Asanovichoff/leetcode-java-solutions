/** problem: Path Existence Queries in a Graph I
 * 
 * approach 1: greedy
 * time complexity: O(n + q)
 * space complexity: O(n + q)
 * 
 * explanation:
 * 1. initialize the groups array with the number of groups
 * 2. for each query, check if the two nodes are in the same group
 * 3. return the result array
 */


class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] groups = new int[n];
        int id = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i-1] > maxDiff) id++;
            groups[i] = id;
        }
        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = groups[queries[i][0]] == groups[queries[i][1]];
        }
        return res;
    }
}