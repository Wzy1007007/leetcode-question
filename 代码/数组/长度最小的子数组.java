package 数组;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0; int sum = 0; int res = Integer.MAX_VALUE;
        for(int j = 0; j < nums.length; j++){
            sum = sum + nums[j];
            while(sum >= target){
                int len = j - i + 1;
                res = Math.min(res, len);
                sum = sum - nums[i];
                i++;
            }
        }
        if(res != Integer.MAX_VALUE) return res;
        else return 0;
    }
}

//滑动窗口思想：窗口起始位置和终止位置
//关键：如何动态移动起始位置
//思路：滑动窗口终止位置不断往右移动，当移动到窗口元素总和大于等于target时，起始位置往右移动直到窗口元素总和再次小于target，然后终止位置再往右移动，重复操作 {

