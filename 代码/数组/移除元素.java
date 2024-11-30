package 数组;

class Solution {
    public int removeElement(int[] nums, int val) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex) {
        // 找左边等于val的元素
            while (leftIndex <= rightIndex && nums[leftIndex] != val){
                ++leftIndex;
            }
        // 找右边不等于val的元素
            while (leftIndex <= rightIndex && nums[rightIndex] == val) {
                -- rightIndex;
            }
        // 将右边不等于val的元素覆盖左边等于val的元素
        if (leftIndex < rightIndex) {
            nums[leftIndex] = nums[rightIndex];
            leftIndex++; 
            rightIndex--;
            }
        }
        return leftIndex; // leftIndex⼀定指向了最终数组末尾的下⼀个元素
    }
}

//双指针法思想:
//快指针按nums原来的元素数一个一个移动
//慢指针在遇到数组值为val时停下，反映非val元素移动位置，最终表示去掉等于val元素值后数组的元素数

//相向双指针
//右指针指向不等于val的数，左指针指向等于val的数，进行交换，左右指针逐渐逼近直到左指针大于右指针（保证交换次数更少)

//双指针：有效减少循环数的方法（暴力法优化）
