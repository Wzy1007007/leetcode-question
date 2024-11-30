package 贪心算法;

// 解法2
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int cursum = 0;
        int totalsum = 0;
        for(int i = 0; i < gas.length; i++){
            cursum += gas[i] - cost[i];
            totalsum += gas[i] - cost[i];
            if(cursum < 0){
                start = i + 1;
                cursum = 0;
            }
        }
        if(totalsum < 0) return -1;
        return start;
    }
}