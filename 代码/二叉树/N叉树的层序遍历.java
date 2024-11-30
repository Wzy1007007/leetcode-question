package 二叉树;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        Queue<Node> queue = new ArrayDeque<Node>();
        if(root == null) return res;
        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> subres = new ArrayList<Integer>();
            while(n > 0){
                //当有子节点的时候才操作for循环
                for(Node child: queue.peek().children){                   
                    queue.offer(child);
                }
                subres.add(queue.poll().val);
                n--;
            }
            res.add(subres);
        }
        return res;
    }
}

//注意子节点有多个时的写法