package 贪心算法;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // 身高从大到小排（身高相同k小的站前面）
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];   // a - b 是升序排列，故在a[0] == b[0]的狀況下，会根据k值升序排列
            return b[0] - a[0];   //b - a 是降序排列，在a[0] != b[0]，的狀況会根据h值降序排列
        });

        //链表加入/删除操作更方便
        LinkedList<int[]> que = new LinkedList<>();

        //核心：低身高的占据选择位置的主动权
        for (int[] p : people) {
            que.add(p[1],p);   //Linkedlist.add(index, value)，将value插入到指定index里
        }

        return que.toArray(new int[people.length][2]);
    }
}
