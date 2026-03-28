/**
 * Problem: Invert Binary Tree
 * Platform: LeetCode
 *
 * Approach (Depth-First Search):
 * 1. Use a depth-first search to invert the binary tree.
 * 2. Use a loop to iterate through the tree and invert the binary tree.
 * 3. Return the result.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * 
 * Explanation:
 * 1. We use a depth-first search to invert the binary tree.
 * 2. We use a loop to iterate through the tree and invert the binary tree.
 * 3. We return the result.
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}