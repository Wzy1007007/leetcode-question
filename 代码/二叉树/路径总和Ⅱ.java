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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res; // 非空判断

        List<Integer> path = new LinkedList<>();
        preorderdfs(root, targetSum, res, path);
        return res;
    }

    public void preorderdfs(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> path) {
        path.add(root.val);
        targetSum -= root.val;
        // 遇到了叶子节点
        if (root.left == null && root.right == null) {
            // 找到了和为 targetsum 的路径
            if (targetSum == 0) {
                res.add(new LinkedList<Integer>(path));
            }
            return; // 如果和不为 targetsum，返回空
        }

        if (root.left != null) {
            preorderdfs(root.left, targetSum, res, path);
            path.remove(path.size() - 1); // 回溯，去除path数组末尾节点值
        }
        if (root.right != null) {
            preorderdfs(root.right, targetSum, res, path);
            path.remove(path.size() - 1); // 回溯，去除path数组末尾节点值
        }
    }
}