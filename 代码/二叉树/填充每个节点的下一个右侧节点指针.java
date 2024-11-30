package 二叉树;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> queue = new ArrayDeque<Node>();
        if(root == null) return root;
        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            Node cur = queue.poll();
            if(cur.left != null) queue.offer(cur.left);
            if(cur.right != null) queue.offer(cur.right);
            while(--n > 0){
                Node next = queue.poll();
                if(next.left != null) queue.offer(next.left);
                if(next.right != null) queue.offer(next.right);
                cur.next = next;
                cur = next;
            }
        }
        return root;
    }
}
