package 贪心算法;

class Solution {
    public int largestSumAfterKNegations(int[] arr, int k) {
        Arrays.sort(arr);
        
        for (int i = 0; i < arr.length && k > 0; i++) {
            if (arr[i] < 0){
                arr[i] = -arr[i];
                k--;
            }
            else{
                break;
            }
        }
        Arrays.sort(arr);
        if (k % 2 == 1){
            arr[0] = -arr[0];
        }

        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += arr[i];
        }
        return res;
    }
}
