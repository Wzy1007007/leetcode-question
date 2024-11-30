package 贪心算法;

class Solution {
    public int candy(int[] ratings) {
        int[] res = new int[ratings.length];
        for(int i = 0; i < res.length; i++){
            res[i] = 1;
        }
        int ans = 0;
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i - 1]){
                res[i] = res[i - 1] + 1;
            }
        }
        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]){
                res[i] = Math.max(res[i], res[i + 1] + 1);
            }
        }
        for(int i = 0; i < res.length; i++){
            ans += res[i];
        }
        return ans;
    }
}
