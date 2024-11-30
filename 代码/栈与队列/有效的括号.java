package 栈与队列;

// class Solution {
//     public boolean isValid(String s) {
//         Deque<Character> stack = new ArrayDeque<Character>();

//         //剪枝：如果s长度为奇数，则一定无效
//         if(s.length() % 2 == 1) return false;

//         for(int i = 0; i < s.length(); i++){
//             //遇到左方向括号
//             if(s.charAt(i) == '(') stack.push(')');
//             else if(s.charAt(i) == '[') stack.push(']');
//             else if(s.charAt(i) == '{') stack.push('}');
//             //遇到右方向括号
//             //严谨起见，要先判断栈是否为空，否则会有异常（栈为空，stack.top()没有意义）
//             else if(stack.isEmpty() || s.charAt(i) != stack.peek()) return false;
//             else stack.pop();
//         }
        
//         //stack遍历结束后还不为空的情况（左括号多了）
//         return stack.isEmpty();
//     }
// }

//无效括号的三种情况
//([{}]() 左括号多了
//[{(]}]  左右括号不匹配
//[{}]())))  右括号多了
//遇到左括号，则把它对应的右括号压入栈（方便匹配）
//遇到右括号，则看栈顶是否与之相同或看是否为空进行判断
//如果最后栈不为空，则一定不是有效的

//也可以用哈希表把键值对写进去（注意写的格式）
class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
