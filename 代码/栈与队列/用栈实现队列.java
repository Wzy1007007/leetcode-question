package 栈与队列;

class MyQueue {
    //栈的声明：Deque类型
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public MyQueue() {
        //instack用于进，outstack用于出
        inStack = new ArrayDeque<Integer>();
        outStack = new ArrayDeque<Integer>();
    }

    public void push(int x) {
        //void push里面的push是函数，instack里面的push是栈带有的功能（下面的pop也是一样）
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            in2out();
        }
        //栈顶元素访问用peek
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    //就是把instack里的元素按栈的规则推到outstack里面
    private void in2out() {
        while (!inStack.isEmpty()) {
            //把instack的栈顶元素移出并压入outstack，inStack.pop()代表栈顶元素
            outStack.push(inStack.pop());
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
