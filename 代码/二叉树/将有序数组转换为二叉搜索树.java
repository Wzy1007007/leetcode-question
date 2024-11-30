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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = sortfunction(nums, 0, nums.length - 1);
        return root;
    }

    public TreeNode sortfunction(int[] nums, int left, int right){
        while(left <= right){
            int middle = left + (right - left) / 2;
            TreeNode root = new TreeNode(nums[middle]);
            root.left = sortfunction(nums, left, middle - 1);
            root.right = sortfunction(nums, middle + 1, right);
            return root;
        }
        return null;
    }
}
