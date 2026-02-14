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
 * Approach (Inorder Traversal):
 * 1. Use a stack to store the nodes.
 * 2. Use a while loop to traverse the tree.
 * 3. Use a while loop to traverse the left subtree.
 * 4. Use a while loop to traverse the right subtree.
 * 5. Return the kth smallest element.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            k--;
            if(k==0) return cur.val;
            cur = cur.right;
        }  
        return -1;
    }
}