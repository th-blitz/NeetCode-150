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
 * Recursive Solution
 * T: O(N)
 * S: O(N)
 */
// class Solution {
//     public TreeNode invertTree(TreeNode root) {
//         invertTreeNode(root);
//         return root;
//     }

//     private void invertTreeNode(TreeNode node) {

//         if (node == null || (node.right == null && node.left == null)) return;

//         TreeNode left = node.left;
//         TreeNode right = node.right;

//         node.left = right;
//         node.right = left;

//         invertTree(node.left);
//         invertTree(node.right);
//     }
// }

/**
 * Iterative Solution
 * T: O(N)
 * S: O(N)
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if (root == null) return root;

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            TreeNode temp = cur.left;

            cur.left = cur.right;
            cur.right = temp;

            if (cur.left != null ) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
        }

        return root;
    }
}