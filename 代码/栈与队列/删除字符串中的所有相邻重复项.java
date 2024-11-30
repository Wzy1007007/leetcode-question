package 栈与队列;

class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> stack1 = new LinkedList<Character>();
        Deque<Character> stack2 = new LinkedList<Character>();
        int n = s.length();
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(stack1.isEmpty() || s.charAt(i) != stack1.peek()){
                stack1.push(s.charAt(i));
            }
            else{
                stack1.pop();
            }
        }
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        while(!stack2.isEmpty()){
            res.append(stack2.pop());
        }
        return res.toString();
    }
}