package 栈与队列;

// class MyStack {
//     //队列的声明：类型为Queue
//     Queue<Integer> queue1;
//     Queue<Integer> queue2;

//     /** Initialize your data structure here. */
//     public MyStack() {
//         //queue2用于进，queue1用于出
//         queue1 = new LinkedList<Integer>();
//         queue2 = new LinkedList<Integer>();
//     }
    
//     /** Push element x onto stack. */
//     public void push(int x) {
//         //把x加入队列用offer
//         queue2.offer(x);
//         while (!queue1.isEmpty()) {
//             //把队列元素移出用poll，queue1.poll()代表queue1头元素
//             queue2.offer(queue1.poll());
//         }
//         Queue<Integer> temp = queue1;
//         queue1 = queue2;
//         queue2 = temp;
//     }
    
//     /** Removes the element on top of the stack and returns that element. */
//     public int pop() {
//         return queue1.poll();
//     }
    
//     /** Get the top element. */
//     public int top() {
//         return queue1.peek();
//     }
    
//     /** Returns whether the stack is empty. */
//     public boolean empty() {
//         return queue1.isEmpty();
//     }
// }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

 //也可以只用一个队列
 class MyStack {
    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        int n = queue.size();
        queue.offer(x);
        //n是x加入队列之前的值
        for (int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        //队列头元素的访问
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
