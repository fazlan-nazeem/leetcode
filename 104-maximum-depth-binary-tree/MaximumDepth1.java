public class MaximumDepth1 {
     class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode() {
         }

         TreeNode(int val) {
             this.val = val;
         }

         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

     // recursive DFS
     public int maxDepth(TreeNode root) {

        if(root == null) {
            return 0;
        }

        int left = 1 + maxDepth(root.left);
        int right = 1 + maxDepth(root.right);
        return Math.max(left, right);
    }
}

// if n is the number of nodes in the binary tree and h is the height of the tree
// time-complexity = O(n)
// space-complexity = O(h) => O(log n) assuming the tree is balanced, O(n) if unbalanced
