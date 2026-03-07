/** 
 * Problem: Count Good Nodes in Binary Tree
 * Platform: LeetCode
 *
 * Approach (Depth First Search):
 * 1. Use a depth first search to count the number of good nodes in the binary tree.
 * 2. Use a helper function to count the number of good nodes in the binary tree.
 * 3. Return the number of good nodes in the binary tree.
 */
/**

/**
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * 
 * Explanation:
 * 1. We use a depth first search to count the number of good nodes in the binary tree.
 * 2. We use a helper function to count the number of good nodes in the binary tree.
 * 3. We return the number of good nodes in the binary tree.
 */


    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, root.val);
    }

    public int dfs(TreeNode node, int maxVal) {
        if (node == null) return 0;

        int count = 0;

        if (node.val >= maxVal) {
            count = 1;
            maxVal = node.val;
        }

        count += dfs(node.left, maxVal);
        count += dfs(node.right, maxVal);

        return count;
    }
}