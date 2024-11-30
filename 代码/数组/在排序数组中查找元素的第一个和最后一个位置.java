package 数组;
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int rightborder = RightBorder(nums, target);
        int leftborder = LeftBorder(nums, target);
        if(leftborder == -2 || rightborder == -2) return new int[]{-1, -1};
        if(rightborder - leftborder > 1) return new int[]{leftborder + 1, rightborder - 1};
        else return new int[]{-1, -1};
    }

    public int RightBorder(int[] nums, int target){
        int left = 0; int right = nums.length - 1; int rightborder = -2;
        while(left <= right){
            int middle = left + (right - left) /2;
            if(nums[middle] > target){
                right = middle - 1;
            }
            else{
                left = middle + 1;
                rightborder = left;
            }
        }
        return rightborder;
    }

    public int LeftBorder(int[] nums, int target){
        int left = 0; int right = nums.length - 1; int leftborder = -2;
        while(left <= right){
            int middle = left + (right - left) /2;
            if(nums[middle] >= target){
                right = middle - 1;
                leftborder = right;
            }
            else{
                left = middle + 1;
            }
        }
        return leftborder;
    }
}

// leftborder：找到第一个小于target的位置；rightborder：找到第一个大于target的位置
// 三种情况的讨论：
// target不在nums里面且target的值不在nums范围内（leftborder、rightborder不动）；
// target不在nums里面但target的值在nums最大值和最小值之间（leftborder、rightborder有动）；
// target在nums里面（leftborder、rightborder之差大于1）

// 注意主函数返回数组的写法