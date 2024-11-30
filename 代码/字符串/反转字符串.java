package 字符串;

class Solution {
    public void reverseString(char[] s) {
        for(int i = 0, j = s.length - 1; i < j; i++, j--){
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}

//直接头尾交换（java不能直接swap）
