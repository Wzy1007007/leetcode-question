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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode res = new TreeNode(val);
        if(root == null) return res;
        TreeNode cur = root;
        TreeNode temp = null;
        while(cur != null){
            temp = cur;
            cur = cur.val > val ? cur.left : cur.right;
        }
        if(val > temp.val) temp.right = res;
        if(val < temp.val) temp.left = res;
        return root;
    }
}