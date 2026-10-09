/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
 * Problem: Maximum Binary Tree
 * Platform: LeetCode
 * Approach :
 * 1. We can solve this problem using a recursive depth-first search (DFS) approach.
 * 2. We will maintain a reference to the input array `nums` and define a recursive function `dfs(l, r)` that constructs the maximum binary tree for the subarray `nums[l:r]`.
 * 3. In each call to `dfs`, we will find the index of the maximum number in the current subarray and create a new TreeNode with that value.
 * 4. We will then recursively construct the left and right subtrees by calling `dfs` on the left and right subarrays, respectively.
 * 5. Finally, we will return the constructed TreeNode as the root of the maximum binary tree.
 */
/**
 * Time Complexity: O(n^2), where n is the number of elements in the input array `nums`, as we may need to find the maximum number in each subarray during the recursive calls.
 * Space Complexity: O(n), where n is the number of elements in the input array `nums`, which is the space required for the recursion stack during the DFS traversal.
 */
class Solution {
    private int[] nums;
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        this.nums = nums;
        return dfs(0, nums.length-1);
    }
    private TreeNode dfs(int l, int r) {
        int idx = findIdxOfMaxNum(l, r);
        if (idx == -1) return null;
        TreeNode node = new TreeNode(nums[idx]);
        node.left = dfs(l, idx-1);
        node.right = dfs(idx+1, r);
        return node;
    }
    private int findIdxOfMaxNum(int l, int r) {
        if (l > r) return -1;
        int maxNum = nums[l], idx = l;
        for (int i = l+1; i <= r; i++) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
                idx = i;
            }
        }
        return idx;
    }
}