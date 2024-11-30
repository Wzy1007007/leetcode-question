package 二叉树;

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
class Solution {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        int depth = 1;
        if(root == null){
            return 0;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            while(n > 0){
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                queue.poll();
                n--;
            }
            if(n == 0 && !queue.isEmpty()){
                depth++;
            }
        }
        return depth;
    }
}
