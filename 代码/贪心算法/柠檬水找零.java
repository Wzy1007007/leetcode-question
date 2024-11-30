package 贪心算法;

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int sum5 = 0;
        int sum10 = 0;
        for(int i = 0; i < bills.length; i++){
            if(bills[i] == 5){
                sum5++;
            }
            else if(bills[i] == 10){
                if(sum5 < 1) return false;
                else{
                    sum5--;
                    sum10++;
                }
            }
            else{
                if(sum10 >= 1){
                    if(sum5 < 1) return false;
                    else{
                        sum10--;
                        sum5--;
                    }
                }
                else{
                    if(sum5 < 3) return false;
                    else sum5 -= 3;
                }
            }
        }
        return true;
    }
}
