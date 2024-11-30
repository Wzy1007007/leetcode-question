package 哈希表;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                break;
            }
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int k = nums.length - 1;
            int target = - nums[i];
            for(int j = i + 1; j < nums.length; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                while(j < k && nums[j] + nums[k] > target){
                    k--;
                }
                if(j == k){
                    break;
                }
                if(nums[j] + nums[k] == target){
                    List<Integer> ans = new ArrayList<Integer>();
                    ans.add(nums[i]);
                    ans.add(nums[j]);
                    ans.add(nums[k]);
                    res.add(ans);
                }
            }
        }
        return res;
    }
}
