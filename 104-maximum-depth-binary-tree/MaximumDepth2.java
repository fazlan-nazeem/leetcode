import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumDepth2 {

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

    // BFS
    public int maxDepth(TreeNode root) {

        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int maxDepth = 0;
        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            maxDepth++;
        }
        return maxDepth;
    }
}

// time-complexity = O(n)
// space-complexity = O(n)