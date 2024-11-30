package 数组;
//搜索插入位置
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int middle = left + (right - left) / 2;
            if(nums[middle] >= target){
                right = middle - 1;
            }
            else{
                left = middle + 1;
            }
        }
        return right + 1;
    }
}

//示例：0 2 3 5 6 7 8 找1和找4
//思路核心：在有序数组中找到第一个大于等于target的下标
//注意看代码随想录中的解答，分类讨论四种情况，关键在于最后return的是right + 1