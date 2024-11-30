package 数组;
//此题需要创建一个新数组存储结果（不算空间复杂度）

//思路1：双指针指向头和尾，以及一个pos指针首先指向结果数组末尾，比较双指针的平方数，更大的加入pos位置的结果数组中，然后根据情况移动这两个指针
// class Solution {
//     public int[] sortedSquares(int[] nums) {
//         int n = nums.length;
//         int[] ans = new int[n];
//         for (int i = 0, j = n - 1, pos = n - 1; i <= j; --pos) {
//             if (nums[i] * nums[i] > nums[j] * nums[j]) {
//                 ans[pos] = nums[i] * nums[i];
//                 ++i;
//             } else {
//                 ans[pos] = nums[j] * nums[j];
//                 --j;
//             }
//         }
//         return ans;
//     }
// }


//思路2：找到负数和非负数的分界，设置双指针分别往两头移动，每次把平方数更小的数加入结果数组中
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int negative = -1;
        for (int i = 0; i < n; ++i) {
            if (nums[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }

        int[] ans = new int[n];
        int index = 0, i = negative, j = negative + 1;
        while (i >= 0 || j < n) {
            if (i < 0) {
                ans[index] = nums[j] * nums[j];
                ++j;
            } else if (j == n) {
                ans[index] = nums[i] * nums[i];
                --i;
            } else if (nums[i] * nums[i] < nums[j] * nums[j]) {
                ans[index] = nums[i] * nums[i];
                --i;
            } else {
                ans[index] = nums[j] * nums[j];
                ++j;
            }
            ++index;
        }

        return ans;
    }
}
