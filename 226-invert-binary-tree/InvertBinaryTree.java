import javax.swing.tree.TreeNode;

public class InvertBinaryTree {
     class TreeNode {
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

    public TreeNode invertTree(TreeNode root) {

        if(root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

// if n is the number of nodes in the binary tree and h is the height of the tree
// time-complexity = O(n)
// space-complexity = O(h) => O(log n) assuming the tree is balanced
