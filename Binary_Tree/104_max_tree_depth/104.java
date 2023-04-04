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


// In complier which supports tail recursion we can do this using tail recursion, to get stack space optimization. Optimization of tail recursion is not supported by python or Java. It is supported by C++.

// Using stack (DFS) and Queue (BFS)
// T: O(N), M: O(N)

// class Solution {
//   public int maxDepth(TreeNode root) {
//     LinkedList<TreeNode> stack = new LinkedList<>();
//     LinkedList<Integer> depths = new LinkedList<>();
//     if (root == null) return 0;

//     stack.add(root);
//     depths.add(1);

//     int depth = 0, current_depth = 0;
//     while(!stack.isEmpty()) {
//       root = stack.pollLast();
//       current_depth = depths.pollLast();
//       if (root != null) {
//         depth = Math.max(depth, current_depth);
//         stack.add(root.left);
//         stack.add(root.right);
//         depths.add(current_depth + 1);
//         depths.add(current_depth + 1);
//       }
//     }
//     return depth;
//   }
// };

// class Solution {
//     public int maxDepth(TreeNode root) {
//         if (root == null) return 0;
// 	Deque<TreeNode> dq = new ArrayDeque<>();
//         int depth = 0, next = 0;
//         TreeNode cur;
//         dq.offer(root);

//         while (!dq.isEmpty()) {
//             depth++;
//             next = dq.size();
//             for (int i = 0; i < next; ++i) {
//                 cur = dq.poll();
//                 if (cur.left != null) dq.offer(cur.left);
//                 if (cur.right != null) dq.offer(cur.right);
//             }
//         }
//         return depth;
//     }
// }

/**
 * T: O(N)
 * S: O(log N) -> balanced tree
 * Extreme case can lead to stack overflow.
 */
// Bottom - Up approach
// class Solution {
//     // T: O(N), M: O(N) -> O(log N)
//     public int maxDepth(TreeNode root) {

//         if(root == null) return 0;

//         int left = maxDepth(root.left);
//         int right = maxDepth(root.right);

//         return Math.max(left, right) + 1;
//     }
// }

// Top - down approach
// class Solution {
//     public int max = 0;
//     public int maxDepth(TreeNode root) {

//         if(root == null) return max;
//         return getHeight(root, 1);
//     }

//     private int getHeight(TreeNode root, int level) {

//         if(root.left == null && root.right == null) {
//             max = Math.max(max, level);
//         }

//         if(root.left != null) getHeight(root.left, level + 1);
//         if(root.right != null) getHeight(root.right, level + 1);
//         return max;
//     }
// }

class Solution {
    int max = 0;
    public int maxDepth(TreeNode root) {

        if (root == null) return max;

        return getDepth(root, 1);
    }

    private int getDepth(TreeNode root, int level) {

        // base case
        if (root.left == null && root.right == null) {
            max = Math.max(max, level);
        }

        if (root.left != null) getDepth(root.left, level + 1);
        if (root.right != null) getDepth(root.right, level + 1);

        return max;
    }
}