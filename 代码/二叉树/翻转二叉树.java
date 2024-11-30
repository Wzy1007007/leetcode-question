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
// //递归法
// class Solution {
//    /**
//      * 前后序遍历都可以
//      * 中序不行，因为先左孩子交换孩子，再根交换孩子（做完后，右孩子已经变成了原来的左孩子），再右孩子交换孩子（此时其实是对原来的左孩子做交换）
//      */
//     public TreeNode invertTree(TreeNode root) {
//         if (root == null) {
//             return null;
//         }
//         invertTree(root.left);
//         invertTree(root.right);
//         swapChildren(root);
//         return root;
//     }

//     private void swapChildren(TreeNode root) {
//         TreeNode tmp = root.left;
//         root.left = root.right;
//         root.right = tmp;
//     }
// }

//BFS
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {return null;}
        Queue <TreeNode> deque = new ArrayDeque<TreeNode>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int n = deque.size();
            while (n-- > 0) {
                TreeNode node = deque.poll();
                swap(node);
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
        }
        return root;
    }

    public void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
