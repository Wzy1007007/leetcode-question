package 二叉树;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//常规方法（二叉树通用）
// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         if(root == null || root == p || root == q){
//             return root;
//         }

//         TreeNode left = lowestCommonAncestor(root.left, p, q);
//         TreeNode right = lowestCommonAncestor(root.right, p, q);

//         if(left == null && right == null) return null;
//         if(left == null) return right;
//         if(right == null) return left;
//         return root;
//     }
// }

// //利用二叉树的性质一次遍历
// class Solution {
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         TreeNode ancestor = root;
//         while (true) {
//             if (p.val < ancestor.val && q.val < ancestor.val) {
//                 ancestor = ancestor.left;
//             } else if (p.val > ancestor.val && q.val > ancestor.val) {
//                 ancestor = ancestor.right;
//             } else {
//                 break;
//             }
//         }
//         return ancestor;
//     }
// }

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }
}