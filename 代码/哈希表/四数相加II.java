package 哈希表;

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        for(int num1 : nums1){
            for(int num2 : nums2){
                int total = map.getOrDefault(num1 + num2, 0) + 1;
                map.put(num1 + num2, total);
                }
        }
        
        for(int num3 : nums3){
            for(int num4 : nums4){
                int search = -(num3 + num4);
                if(map.containsKey(search)){
                    count += map.get(search);
                }
            }
        }
        return count;
        }
    }

