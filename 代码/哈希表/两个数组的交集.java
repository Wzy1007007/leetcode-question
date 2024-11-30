package 哈希表;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0 || nums1 == null || nums2 == null)
        return new int[0];

        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> resSet = new HashSet<Integer>();

        for(int i : nums1){
            set.add(i);
        }

        for(int j : nums2){
            if(set.contains(j)){
                resSet.add(j);
            }
        }

        int[] res = new int[resSet.size()];
        int k = 0;
        for(int num: resSet){
            res[k++] = num;
        }

        return res;

        //快捷方法
        // return resSet.stream().mapToInt(x -> x).toArray();
        
    }
}

//数组元素不多，但数值很大（例如1000000）或很分散，不适合用数组哈希表
//采用set哈希表：元素不重复（和nums1,nums2实际长度无关）
