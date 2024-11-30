package 贪心算法;

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
    int res = 0;
    public int minCameraCover(TreeNode root) {
        // 对根节点的状态做检验,防止根节点是无覆盖状态 .
        if(minCame(root) == 0){
            res++;
        }
        return res;
    }
    /**
     节点的状态值：
       0 表示无摄像头覆盖
       1 表示有摄像头
       2 表示有摄像头覆盖
    后序遍历，根据左右节点的情况，来判读自己的状态
     */
    public int minCame(TreeNode root){
        if(root == null){
            // 空节点默认为有覆盖状态，避免在叶子节点上放摄像头
            return 2;
        }
        int left = minCame(root.left);
        int right = minCame(root.right);

        // 如果左右节点都覆盖了的话, 那么不需要摄像头去覆盖两个子节点，本节点的状态就应该是无覆盖
        if(left == 2 && right == 2){
            //(2,2)
            return 0;
        }
        else if(left == 0 || right == 0){
            // 左右节点有一个无覆盖状态,那根节点此时应该放一个摄像头，否则存在一个节点没有摄像头覆盖
            // (0,0) (0,1) (0,2) (1,0) (2,0)
            // 状态值为 1 摄像头数 ++;
            res++;
            return 1;
        }
        else{
            // 左右节点的状态为 (1,1) (1,2) (2,1) 也就是左右节点至少存在1个摄像头，
            // 那么本节点就是处于被覆盖状态，不需要再放摄像头
            return 2;
        }
    }
}