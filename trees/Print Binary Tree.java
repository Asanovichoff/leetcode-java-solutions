/**
 * Problem: Print Binary Tree
 * Platform: LeetCode
 *
 * Approach (Tree):
 * 1. Use a tree to print the binary tree.
 * 2. Use a loop to iterate through the tree and print the binary tree.
 * 3. Return the result.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a tree to print the binary tree.
 * 2. We use a loop to iterate through the tree and print the binary tree.
 * 3. We return the result.
 */
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
class Solution {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        int height = findHeight(root);
        int rows = height;
        int cols = (int) Math.pow(2,height) - 1;
        for (int i = 0; i < rows; i++) {
            ArrayList<String> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add("");
            }
            res.add(row);
        }
        fill(root, res, 0, 0, cols-1);
        return res;
    }
    private int findHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(findHeight(node.right), findHeight(node.left));
    }
    private void fill (TreeNode node, List<List<String>> res, int row, int l, int r) {
        if (node == null) return;
        int m = (r+l)/2;
        res.get(row).set(m, String.valueOf(node.val));
        fill (node.left, res, row+1, l, m-1);
        fill (node.right, res, row+1, m+1, r);
    }
}
