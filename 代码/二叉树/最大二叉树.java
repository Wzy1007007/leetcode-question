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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    public TreeNode construct(int[] nums, int left, int right) {
        //递归终止条件
        if (left > right) {
            return null;
        }
        //找最大值的值和位置，每次把最大值作为节点加入答案
        int best = left;
        for (int i = left + 1; i <= right; ++i) {
            if (nums[i] > nums[best]) {
                best = i;
            }
        }
        TreeNode node = new TreeNode(nums[best]);
        //递归逻辑
        node.left = construct(nums, left, best - 1);
        node.right = construct(nums, best + 1, right);
        return node;
    }
}
