/**
 * Problem: Smallest String Starting From Leaf
 * Platform: LeetCode
 *
 * Approach (Depth First Search):
 * 1. Use a depth first search to find the smallest string starting from the leaf.
 * 2. Use a helper function to find the smallest string starting from the leaf.
 * 3. Return the smallest string starting from the leaf.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * 
 * Explanation:
 * 1. We use a depth first search to find the smallest string starting from the leaf.
 * 2. We use a helper function to find the smallest string starting from the leaf.
 * 3. We return the smallest string starting from the leaf.
 */
class Solution {
    private String s = null;
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, "");
        return s;
    }
    private void dfs(TreeNode node, String path) {
        if (node == null) return;
        path = (char)('a' + node.val) + path;

        if (node.left == null && node.right == null) {
            if (s == null || path.compareTo(s) < 0) s = path;
        }
        dfs(node.left, path);
        dfs(node.right, path);
    }

}
