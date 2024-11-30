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
//自己写的
// class Solution {
//     public TreeNode searchBST(TreeNode root, int val) {
//         while(root != null){
//             if(val < root.val) root = root.left;
//             if(root != null && val > root.val) root = root.right;
//             if(root != null && val == root.val) return root;
//         }
//         return null;
//     }
// }

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (val == root.val) {
                return root;
            }
            //写成一句话就不存在root为空的问题了
            root = val < root.val ? root.left : root.right;
        }
        return null;
    }
}