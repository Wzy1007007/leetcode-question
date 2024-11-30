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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        if(root == null) return res;
        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> subres = new ArrayList<Integer>();
            while(n > 0){
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subres.add((queue.poll()).val);
                n--;
            }
            res.add(subres);
        }
        Collections.reverse(res);
        return res;        
    }
}
