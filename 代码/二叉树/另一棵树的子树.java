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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        //层次遍历s,依次比较【以s中的结点为根结点的子树】与t是否相等
        Queue<TreeNode> q = new LinkedList();
        q.offer(s);
        while(!q.isEmpty()){
            TreeNode ts = q.poll();
            boolean res = sameTree(ts,t);
            //找到一个节点符合条件就可以返回了
            if(res == true){
                return true;
            }
            
            if(ts.left != null){
                q.offer(ts.left);
            }
            if(ts.right != null){
                q.offer(ts.right);
            }
        }    
        return false;
    }
   
    public boolean sameTree(TreeNode s, TreeNode t){
        Queue<TreeNode> r = new LinkedList();
        r.offer(s);
        r.offer(t);
        while(!r.isEmpty()){
            TreeNode first = r.poll();
            TreeNode second = r.poll();
            //要考虑空节点的情况
            if(first == null && second == null){
                continue;
            }
            if(first == null || second == null || first.val != second.val){
                return false;
            }
            r.offer(first.left);
            r.offer(second.left);
            r.offer(first.right);
            r.offer(second.right);
        }
        return true;
    }
}
