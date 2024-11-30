package 字符串;

class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            reverse(arr, i, Math.min(i + k, n) - 1);
            //reverse函数变量是left和right，是将i的相关表达值分别传给left和right，不会改变i的值
        }
        return new String(arr);
    }

    public void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}

//关键在于Math.min(i + k, n) - 1的处理，覆盖题目的两种不同要求
//剩余字符少于k个：i + k会超过n；
//剩余字符多于（或等于）k个：i + k小于等于n