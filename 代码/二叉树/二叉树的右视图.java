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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            while(n > 0){
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                if(n-- == 1) res.add(queue.peek().val);
                queue.poll();
            }
        }
        return res;
    }
}
