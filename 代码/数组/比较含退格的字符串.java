package 数组;

class Solution {
    public boolean backspaceCompare(String S, String T) {
        // 初始化指针 i 和 j，分别指向字符串 S 和 T 的最后一个字符
        int i = S.length() - 1, j = T.length() - 1;
        // 用于记录需要删除的字符数量
        int skipS = 0, skipT = 0;

        // 当 i 或 j 仍在有效范围内时继续循环
        while (i >= 0 || j >= 0) {
            // 处理字符串 S 的字符
            while (i >= 0) {
                // 如果当前字符是 '#'，增加删除的字符数量
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--; 
                } else if (skipS > 0) {
                    // 如果当前字符不是#，且需要删除的字符数量不为0，则需删除该字符，相应的需要删除的字符数量要减1
                    skipS--; 
                    i--; 
                } else { 
                    break; // 需要删除的字符数为0，则跳过操作
                }
            }

            // 处理字符串 T 的字符
            while (j >= 0) {
                // 如果当前字符是 '#'，增加删除的字符数量
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--; 
                } else if (skipT > 0) {
                    // 如果当前字符不是#，且需要删除的字符数量不为0，则需删除该字符，相应的需要删除的字符数量要减1
                    skipT--; 
                    j--; 
                } else {
                    break; // 需要删除的字符数为0，则跳过操作
                }
            }

            // 比较当前有效字符
            if (i >= 0 && j >= 0) {
                // 如果两个字符不同，返回 false
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                // 如果其中一个字符串已经处理完，而另一个还没处理完，返回 false
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            // 移动到下一个字符进行比较
            i--; // 移动指针 i 向左
            j--; // 移动指针 j 向左
        }
        // 如果所有字符都相同，返回 true
        return true;
    }
}