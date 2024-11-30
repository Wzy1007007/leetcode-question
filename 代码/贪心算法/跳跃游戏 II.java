package 贪心算法;

class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int res = 0;
        int cur = 0; //当前最远的覆盖位置
        int next = 0; //下一元素可以覆盖的最远位置
        //注意是遍历到nums.length - 2，否则会多算一次
        for(int i = 0; i < nums.length - 1; i++){
            if(i <= next){
                next = Math.max(next, i + nums[i]);
                if(i == cur){
                res++;
                cur = next;
                }
            }
        }
        return res;
    }
}