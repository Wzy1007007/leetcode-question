package 栈与队列;

// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int left = 0, right = k - 1;
//         int [] ans = new int[nums.length - k + 1];
//         for(; right < nums.length; left++, right++){
//             int res = nums[left];
//             for(int i = left + 1; i <= right; i++){
//                 if(nums[i] >= res){
//                     res = Math.max(res, nums[i]);
//                 }
//             }
//             ans[left] = res;
//         }
//         return ans;
//     }
// }

//暴力法：超时
//单调队列：使队列元素单调递减，维护窗口可能出现的最大值
//每次操作分为：(1)pop被移出窗口的元素(如果元素之前被弹出，就不用执行该操作）
//(2)push新加入窗口的元素，以及(3)返回每个窗口的最大值
//遍历数组元素加入队列，如果比队列前面的元素大，就把前面的元素弹出队列(维护它没有意义)

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            // 删除 deque 中对应的 nums[i-1]，如果 deque 头元素不是 nums[i-1] 则之前被弹出了，不用再删除了
            if(i > 0 && deque.peekFirst() == nums[i - 1])
                deque.removeFirst();
            // 保持 deque 递减 (头部为当前滑动窗口的最大值)
            while(!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast();
            deque.addLast(nums[j]);
            // 记录窗口最大值
            if(i >= 0)
                res[i] = deque.peekFirst();
        }
        return res;
    }
}

