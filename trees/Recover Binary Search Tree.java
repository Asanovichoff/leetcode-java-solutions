/** problem Recover Binary Search Tree 
 * approach 1: inorder traversal
 * time complexity: O(n)
 * space complexity: O(h)
 * 
 * explanation:
 * 1. inorder traversal of the tree
 * 2. if the previous node is greater than the current node, then there is a mistake
 * 3. if the node1 is not found, then set the node1 to the previous node
 * 4. if the node1 is found, then set the node2 to the current node
 * 5. swap the values of the node1 and the node2
 * 6. return the root node
*/

class Solution {
    TreeNode node1;
    TreeNode node2;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);
        inOrder(root);
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
    private void inOrder(TreeNode cur) {
        if (cur == null) return;
        inOrder(cur.left);
        if (prev != null && prev.val > cur.val) {
            if (node1 != null) {
                node2 = cur;
            }else {
                node1 = prev;
                node2 = cur;
            }    
        }
        prev = cur;
        inOrder(cur.right);
    }
}