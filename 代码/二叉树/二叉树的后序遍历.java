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
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> res = new ArrayList<Integer>();
//         traversal(root, res);
//         return res;
//     }

//     public void traversal(TreeNode root, List<Integer> res){
//         if(root == null) return;
//         traversal(root.left, res);
//         traversal(root.right, res);
//         res.add(root.val);
//     }
// }

//迭代法
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        //Java对List数组进行反转
        Collections.reverse(result);
        return result;
    }
}
