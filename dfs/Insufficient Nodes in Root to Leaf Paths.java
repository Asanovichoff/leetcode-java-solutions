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
 * Problem: Insufficient Nodes in Root to Leaf Paths
 * Platform: LeetCode
 * Approach :
 * 1. We can solve this problem using a depth-first search (DFS) traversal of the binary tree.
 * 2. For each node, we will calculate the sum of the values of all nodes in the path from the root to the current node.
 * 3. If the sum of the path from the root to a leaf node is less than the given limit, we will remove that leaf node from the tree.
 * 4. We will recursively apply this process to all nodes in the tree, and return the modified tree.
 */
/**
 * Time Complexity: O(n), where n is the number of nodes in the binary tree, as we are visiting each node once during the DFS traversal.
 * Space Complexity: O(h), where h is the height of the binary tree, which is the maximum depth of the recursion stack during the DFS traversal.
 *  In the worst case, the height of the tree can be equal to the number of nodes (n) in the case of a skewed tree, leading to O(n) space complexity
 */
class Solution {
    private int limit;
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        this.limit = limit;
        return dfs(root,0);
    }
    private TreeNode dfs(TreeNode cur, int sum) {
        if (cur.left == null && cur.right == null) {
            if (sum + cur.val < limit) return null;
            else return cur;
        }
        if (cur.left != null) cur.left = dfs(cur.left, sum + cur.val);
        if (cur.right != null) cur.right = dfs(cur.right, sum + cur.val);
        if (cur.left == null && cur.right == null) return null;
        return cur;
    }
}