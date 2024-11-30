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
//  //递归法
// class Solution {
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> res = new ArrayList<Integer>();
//         traversal(res, root);
//         return res;
//     }

//     public void traversal(List<Integer> res, TreeNode root){
//         if(root == null) return;
//         res.add(root.val);
//         traversal(res, root.left);
//         traversal(res, root.right);
//     }
// }

//迭代法
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        //root为空的特殊情况判断一定要有
        if(root == null) return res;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode top = stack.pop();
            res.add(top.val);
            if(top.right != null) stack.push(top.right);
            if(top.left != null) stack.push(top.left);
        }
        return res;
    }
}
//迭代法：利用栈后进先出的思想