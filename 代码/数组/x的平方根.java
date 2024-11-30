package 数组;

class Solution {
    public int mySqrt(int x) {
        long left = 0; long right = x; long output = x;
        while(left <= right)
        {
            long middle = left + (right - left) /2;
            long res = x - middle * middle;
            if(res >= 0){
                left = middle + 1;
                output = middle;
            }
            else{
                right = middle - 1;
            }
        }
        return (int)output;
    }
}

//找到最大的i使得x-i^2为非负数

//对4：0 1 2 3 4
//对8：0 1 2 3 4 5 6 7 8
//对1：0 1

//第一次编译没通过的原因：数据类型错误，须让middle变为long类型再与x操作得到res(因为res最初的结果可能很大)
//解决方式是让所有变量类型全为long然后在最后将output转为int
