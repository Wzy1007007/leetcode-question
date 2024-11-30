package 贪心算法;

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int res = 1;
        for(int i = 1; i < points.length; i++){
            if(points[i][0] > points[i - 1][1]){
                res++;
            }
            else{
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }
        return res;
    }
}