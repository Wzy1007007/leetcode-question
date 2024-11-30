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
 //递归法
// class Solution {
//     public TreeNode trimBST(TreeNode root, int low, int high) {
//         if (root == null) {
//             return null;
//         }
//         if (root.val < low) {
//             return trimBST(root.right, low, high);
//         } else if (root.val > high) {
//             return trimBST(root.left, low, high);
//         } else {
//             root.left = trimBST(root.left, low, high);
//             root.right = trimBST(root.right, low, high);
//             return root;
//         }
//     }
// }

//迭代法
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        //先以根节点为起点去判断并处理，确定新的根节点
        while (root != null && (root.val < low || root.val > high)) {
            if (root.val < low) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        if (root == null) {
            return null;
        }
        //以新的根节点为起点，对左/右子树分别进行处理
        for (TreeNode node = root; node.left != null; ) {
            if (node.left.val < low) {
                node.left = node.left.right;
            } else {
                node = node.left;
            }
        }
        for (TreeNode node = root; node.right != null; ) {
            if (node.right.val > high) {
                node.right = node.right.left;
            } else {
                node = node.right;
            }
        }
        return root;
    }
}