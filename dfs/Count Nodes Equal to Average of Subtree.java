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
 * Problem: Count Nodes Equal to Average of Subtree
 * Platform: LeetCode
 * Approach :
 * 1. We can solve this problem using a depth-first search (DFS) traversal of the binary tree.
 * 2. For each node, we will calculate the sum of the   values of all nodes in its subtree and the number of nodes in its subtree.
 * 3. We will then check if the average of the subtree (sum of values divided by the number of nodes) is equal to the value of the current node.
 * 4. If it is, we will increment a counter that keeps track of the number of nodes that satisfy this condition.
 * 5. Finally, we will return the counter as the result.
 */
/**
 * Time Complexity: O(n), where n is the number of nodes in the binary tree, as we are visiting each node once during the DFS traversal.
 * Space Complexity: O(h), where h is the height of the binary tree, which is the maximum depth of the recursion stack during the DFS traversal.
 *  In the worst case, the height of the tree can be equal to the number of nodes (n) in the case of a skewed tree, leading to O(n) space complexity
 */
class Solution {
    private int res = 0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return res;
    }
    private int[] dfs (TreeNode cur) {
        if (cur == null) return new int[]{0,0};
        int[] left = dfs(cur.left);
        int[] right = dfs(cur.right);
        int sum = cur.val + left[0] + right[0];
        int numOfNodes = 1 + left[1] + right[1];
        if (sum / numOfNodes == cur.val) res++;
        return new int[]{sum, numOfNodes};

    }
}