package 数组;

class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 0, right = num;
        while(left <= right){
            int middle = left + (right - left) / 2;
            if((long)middle * middle == num){
                return true;
            }
            else if((long)middle * middle > num){
                right = middle - 1;
            }
            else{
                left = middle + 1;
            }
        }
        return false;
    }
}

//对4：0 1 2 3 4
//对8：0 1 2 3 4 5 6 7 8
//对1：0 1

//和x的平方根题目极其类似