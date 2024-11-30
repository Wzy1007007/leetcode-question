package 贪心算法;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int res = 0;
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < intervals[i - 1][1]){
                intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1]);
                res++;
            }
        }
        return res;
    }
}
