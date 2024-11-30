package 贪心算法;

class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        //当前差值
        int curDiff = 0;
        //上一个差值
        int preDiff = 0;
        //默认最右边有一个摆动
        int count = 1;
        //i=0代表从首元素开始（初始化prediff为0相当于在首元素前给了一个相同值的平坡）
        for (int i = 0; i < nums.length - 1; i++) {
            //得到当前差值
            curDiff = nums[i + 1] - nums[i];
            //如果当前差值和上一个差值为一正一负
            //等于0的情况表示初始时的preDiff
            //要考虑上坡/下坡中带有平坡的情况
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }
}
