import java.util.*;

class ValidateBST {

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
// class Solution {

//     // Top - down appraoch
//     // T: O(N)
//     // S: O(N) -> Skewed tree
//     public boolean isValidBST(TreeNode root) {

//        return validate(root, null, null);

//     }

//     private boolean validate(TreeNode root, Integer low, Integer high) {

//         if (root == null) return true;

//         if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
//             return false;
//         }

//         return (validate(root.left, low, root.val) && validate(root.right, root.val, high));
//     }
// }

// class Solution {

//     // In order traveral
//     // T: O(N)
//     // S: O(N) -> Skewed tree

//     private Integer prev;

//     public boolean isValidBST(TreeNode root) {
//         prev = null;

//         return inorder(root);

//     }

//     private boolean inorder(TreeNode root) {

//         if (root == null) return true;

//         if (!inorder(root.left)) return false;

//         if (prev != null && root.val <= prev) return false;

//         prev = root.val;

//         return inorder(root.right);
//     }
// }

// class Solution {

//     // Iterative solution with range limits
//     // T: O(N)
//     // S: O(N) -> Skewed tree
//  private Deque<TreeNode> stack = new LinkedList();
//     private Deque<Integer> upperLimits = new LinkedList();
//     private Deque<Integer> lowerLimits = new LinkedList();

//     public void update(TreeNode root, Integer low, Integer high) {
//         stack.add(root);
//         lowerLimits.add(low);
//         upperLimits.add(high);
//     }

//     public boolean isValidBST(TreeNode root) {
//         Integer low = null, high = null, val;
//         update(root, low, high);

//         while (!stack.isEmpty()) {
//             root = stack.poll();
//             low = lowerLimits.poll();
//             high = upperLimits.poll();

//             if (root == null) continue;
//             val = root.val;
//             if (low != null && val <= low) {
//                 return false;
//             }
//             if (high != null && val >= high) {
//                 return false;
//             }
//             update(root.right, val, high);
//             update(root.left, low, val);
//         }
//         return true;
//     }
// }

    class Solution {

        // Iterative solution for inorder method
        // T: O(N)
        // S: O(N) -> Skewed tree
        private Deque<TreeNode> stack = new LinkedList();
        public boolean isValidBST(TreeNode root) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            Integer prev = null;

            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                // If next element in inorder traversal
                // is smaller than the previous one
                // that's not BST.
                if (prev != null && root.val <= prev) {
                    return false;
                }
                prev = root.val;
                root = root.right;
            }
            return true;
        }
    }
}