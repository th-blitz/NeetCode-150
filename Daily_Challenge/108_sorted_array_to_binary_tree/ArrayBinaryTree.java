import java.util.Random;

class ArrayBinaryTree {
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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
// class Solution {
//     // Types of DFS tree traversal (Inorder, preorder, postorder)
//     // Inorder is not unique identifier of BST.
//     // Preorder and postorder are unique identifiers of BST.
//     // Inorder = sorted(preorder) = sorted(postorder)
//     // We can decode BST from inorder + preorder or inorder + postorder
//     // From inorder we can construct multiple BST's
//     // Even with height balanced restriction, we can still construct multiple solutions.
//     // The middle number is always taken as root

//     // T: O(N) -> All nodes are visited only once
//     // S: O(Log N) -> Stack space atmost log N since it is height balanced
//     int[] nums;
//     public TreeNode sortedArrayToBST(int[] nums) {
//         this.nums = nums;
//         return BFS(0, nums.length - 1);
//     }

//     private TreeNode BFS(int left, int right) {
//         if (left > right) return null;

//         int mid = (left + right) / 2;

//         TreeNode root = new TreeNode(nums[mid]);

//         root.left = BFS(left, mid - 1);
//         root.right = BFS(mid + 1, right);

//         return root;
//     }
// }

    //class Solution {
        // Types of DFS tree traversal (Inorder, preorder, postorder)
        // Inorder is not unique identifier of BST.
        // Preorder and postorder are unique identifiers of BST.
        // Inorder = sorted(preorder) = sorted(postorder)
        // We can decode BST from inorder + preorder or inorder + postorder
        // From inorder we can construct multiple BST's
        // Even with height balanced restriction, we can still construct multiple solutions.
        // The middle number is always taken as root

        // Preorder Always choosing right middle node as root
        // T: O(N) -> All nodes are visited only once
        // S: O(Log N) -> Stack space atmost log N since it is height balanced
        int[] nums;
        Random rand = new Random();
        public TreeNode sortedArrayToBST(int[] nums) {
            this.nums = nums;
            return BFS(0, nums.length - 1);
        }

        private TreeNode BFS(int left, int right) {
            if (left > right) return null;

            // always choose right middle node as a root
            int mid = (left + right) / 2;
            if ((left + right) % 2 == 1) ++mid;

            // choose random middle node as a root
            // int p = (left + right) / 2;
            // if ((left + right) % 2 == 1) p += rand.nextInt(2);

            // rand.nextInt(2) -> generates random number of either 0 or 1.

            TreeNode root = new TreeNode(nums[mid]);

            root.left = BFS(left, mid - 1);
            root.right = BFS(mid + 1, right);

            return root;
        }
    //}

    public static void main(String[] args) {

        ArrayBinaryTree obj = new ArrayBinaryTree();
        int[] nums = new int[] {-10,-3,0,5,9};

        if (args == null || args.length == 0) {
            System.out.println("Binary Tree: ");
            System.out.println("Test Case: 1");
            System.out.println("Array = [-10,-3,0,5,9]");
            System.out.println("Possible Binary Tree: " + obj.sortedArrayToBST(nums));

            System.out.println("-------------------------------------");
        }
    }
}