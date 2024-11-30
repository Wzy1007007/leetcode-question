package 数组;

class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 1; int fast = 1;
        if(nums.length == 0) return 0;
        while(fast < nums.length){
            if(nums[fast] == nums[slow - 1]){
                fast++;
            }
            else{
                nums[slow] = nums[fast];
                fast++;
                slow++;
            }
        }
        return slow;
    }
}

//思路：双指针法（移除元素常用）
//fast对应的值等于slow-1时证明有重复值，此时slow停下，fast移动，直至不相等时将fast的值赋给slow，此时slow移动，以此类推

//自己写的代码不严谨之处：少了第四行，如果数组长度为0则返回0