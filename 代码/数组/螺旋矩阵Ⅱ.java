package 数组;

class Solution {
    public int[][] generateMatrix(int n) {
        int [][] nums = new int[n][n];
        int loop = n/2;
        int startx = 0, starty = 0; //这个地方可以合二为一，用一个变量表示
        int offset = 1;
        int count = 1;
        int i, j;  //要作为全局变量，i代表行，j代表列
        while(loop > 0){
            for(j = starty; j < n - offset; j++){
                nums[startx][j] = count++;
            }
            for(i = startx; i < n - offset; i++){
                nums[i][j] = count++;
            }
            for(; j > starty; j--){ //j不需要初始化了
                nums[i][j] = count++;
            }
            for(; i > startx; i--){ //i不需要初始化了
                nums[i][j] = count++;
            }
            startx++;
            starty++;
            offset++;
            loop--;
        }
    if(n % 2 == 1){
        nums[n / 2][n / 2] = count;
    }
    return nums;
    }
}

//循环不变量：区间遍历方式不变（如对每一行/列统一采取左闭右开）
//转的圈数为n/2，若n为奇数，则会留下中间那个位置
// 1 2 3 4 5
// 5 6 7 8 5
// 1 2 3 4 5
// 5 6 7 8 5
// 5 6 7 8 5
//每一圈的起始位置是要变化的，终止位置也要变化（设置startx、starty、offset，一圈结束后都要增加1）
//思路顺序：
//1.确定while循环的判断条件（转的圈数），由此设定loop变量
//2.确定每次转圈的起点是不一样的（由此有了startx，starty），并且每次转圈终点也不同（由此有了offset）
//3.设定4个for循环完成每次转圈，注意确定分析每个for循环更新nums的角标
//4.转圈结束以后如何更新startx，starty，offset和loop
//5.特殊情况特殊分析（n为奇数）