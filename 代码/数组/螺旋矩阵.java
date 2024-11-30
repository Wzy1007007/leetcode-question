package 数组;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> nums = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return nums;
        int l = 0, r = matrix[0].length - 1, u = 0, d = matrix.length - 1;
        while(true){
            for(int j = l; j <= r; j++){
                nums.add(matrix[u][j]);
            }
            if(++u > d) break;
            for(int i = u; i <= d; i++){
                nums.add(matrix[i][r]);
            }
            if(--r < l) break;
            for(int j = r; j >= l; j--){
                nums.add(matrix[d][j]);
            }
            if(--d < u) break;
            for(int i = d; i >= u; i--){
                nums.add(matrix[i][l]);
            }
            if(++l > r) break;
        }
        return nums;
    }
}

// 1  2  3  4
// 5  6  7  8
// 9 10 11 12
// 13 14 15 16
//思路（相比于螺旋矩阵Ⅱ方法的另一种写法，本质其实是一样，只是Ⅱ的方法从圈数入手讨论，该题直接从边界入手讨论）
//设置上下左右四个边界，每次遍历一条边后把对应的边界进行加1或减1
//遵循原则：左闭右闭
//关键：循环什么时候退出，即上与下边界/左与右边界相对位置颠倒(出问题)的时候break

//注意Java中数组的声明方式