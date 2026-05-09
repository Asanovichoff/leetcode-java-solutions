/**
 * Problem: Binary Tree Paths
 * Platform: LeetCode
 *
 * Approach (Depth First Search):
 * 1. Use a depth first search to find all the paths in the binary tree.
 * 2. Use a helper function to find all the paths in the binary tree.
 * 3. Return the paths in the binary tree.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * 
 * Explanation:
 * 1. We use a depth first search to find all the paths in the binary tree.
 * 2. We use a helper function to find all the paths in the binary tree.
 * 3. We return the paths in the binary tree.
 */
class Solution {
    private List<String> result;

    public List<String> binaryTreePaths(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, new StringBuilder());
        return result;
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) return;

        int len = sb.length();

        if (sb.length() != 0) {
            sb.append("->");
        }

        sb.append(node.val);

        if (node.left == null && node.right == null) {
            result.add(sb.toString());
        } else {
            dfs(node.left, sb);
            dfs(node.right, sb);
        }

        sb.setLength(len); // backtrack
    }
}
