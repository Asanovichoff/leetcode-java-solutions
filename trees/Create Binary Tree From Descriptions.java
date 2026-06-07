/**
 * Problem: Create Binary Tree From Descriptions
 * Platform: LeetCode
 *
 * Approach (Tree):
 * 1. Use a tree to create a binary tree from descriptions.
 * 2. Use a loop to iterate through the descriptions and create a binary tree.
 * 3. Return the binary tree.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a tree to create a binary tree from descriptions.
 * 2. We use a loop to iterate through the descriptions and create a binary tree.
 * 3. We return the binary tree.
 */
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] description : descriptions) {
            int parentVal = description[0];
            int childVal = description[1];
            int isLeft = description[2];
            map.putIfAbsent(parentVal, new TreeNode(parentVal));
            map.putIfAbsent(childVal, new TreeNode(childVal));

            TreeNode parent = map.get(parentVal);
            TreeNode child = map.get(childVal);

            if (isLeft == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            children.add(childVal);
        }
        for (int value : map.keySet()) {
            if (!children.contains(value)) {
                return map.get(value);
            }
        }
        return null;
    }
}
