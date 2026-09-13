/**
 *  * Problem: Maximum Binary Tree
 * * Platform: LeetCode
 * * Approach :
 * 1. We can solve this problem using a recursive depth-first search (DFS) approach.
 * 2. We will maintain a reference to the input array `arr` and define a recursive function `dfs(i)` 
 * that computes the maximum sum after partitioning the subarray starting from index `i`.
 * 3. In each call to `dfs`, we will iterate through the next `k` elements (or until the end of the array) to find the maximum number in the current window and calculate the sum for that partition.
 * 4. We will recursively call `dfs` for the next index after the current partition and keep track of the maximum sum obtained.
 * 5. Finally, we will return the maximum sum obtained after partitioning the entire array.
 */
/**
 * Time Complexity: O(n*k), where n is the number of elements in the input array `arr`, and k is the maximum partition size, as we may need to explore up to k elements for each index during the recursive calls.
 * Space Complexity: O(n), where n is the number of elements in the input array `arr`, which is the space required for the recursion stack and the cache array used for memoization.
 */

class Solution {
    private Integer[] cache;
    private int[] arr;
    private int k;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        this.arr = arr;
        this.k = k;
        cache = new Integer[arr.length];
        return dfs(0);
    }
    private int dfs(int i) {
        if (i >= arr.length) return 0;
        if (cache[i] != null) return cache[i];
        int res = 0;
        int curMaxNum = 0;
        for (int j = i; j < Math.min(arr.length, i + k); j++) {
            curMaxNum = Math.max(curMaxNum, arr[j]);
            int windowSize = j-i+1;
            res = Math.max(res, dfs(j+1) + curMaxNum * windowSize);
        }
        cache[i] = res;
        return res;
    }
}
//[1,1,1,3,3,4,5,6,7,9,9]