package 哈希表;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //本题是大的往小的进行交集，因此先用哈希表统计小数组的值及对应出现次数，然后遍历大数组对出现次数进行-1操作
        //（小的往大的进行交集也可以）
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        //数字的次数统计要用map，和字符统计不同，因为统计数字次数时用数组哈希表不能确定哈希表大小
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        //nums1.length是intersection的最长长度
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        //确定输出数组的范围
        return Arrays.copyOfRange(intersection, 0, index);
    }
}