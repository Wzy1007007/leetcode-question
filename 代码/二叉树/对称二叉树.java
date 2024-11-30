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
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode root1, TreeNode root2)
    {
        Deque<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root1); que.offer(root2);
        TreeNode p = root1, q = root2;
        while(!que.isEmpty())
        {
            p = que.pop();
            q = que.pop(); 
            if(p == null && q == null) continue;
            if(p == null || q == null || p.val != q.val) 
            return false;

            que.offer(p.left);
            que.offer(q.right);
            que.offer(p.right);
            que.offer(q.left);
        }
        return true;
    }
}
