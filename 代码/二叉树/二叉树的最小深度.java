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
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        if(root == null) return 0;
        queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty()){
            int n = queue.size();
            depth++;
            while(n > 0){
                //发现某层有空节点就直接返回depth结束程序
                if(queue.peek().left == null && queue.peek().right == null){
                    return depth;
                }
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                queue.poll();
                n--;
            }
        }
        return depth;
    }
}