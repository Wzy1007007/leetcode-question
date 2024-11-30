package 数组;

class Solution {
    // totalFruit方法计算在一次最多采摘两种水果时能采摘的水果数量
    public int totalFruit(int[] fruits) {
        int n = fruits.length; // 获取水果数组的长度
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>(); // 创建一个哈希表，用于记录每种水果的计数

        int left = 0, ans = 0; // 初始化左指针left和最终结果ans
        // 遍历数组，相当于移动右指针
        for (int right = 0; right < n; ++right) {
            // 将第right个水果放入计数器，或者更新其计数
            // getOrDeafault的意思是如果fruits[right]存在于哈希表，则get环节将它的计数（value值）加1，如果不存在则OrDefault环节将其值设置为1
            cnt.put(fruits[right], cnt.getOrDefault(fruits[right], 0) + 1);
            
            // 当当前计数器的种类数量超过2时，需要缩小窗口
            while (cnt.size() > 2) {
                // 从左边移除水果并更新计数
                cnt.put(fruits[left], cnt.get(fruits[left]) - 1);
                // 如果计数为0，则从哈希表中移除该水果
                if (cnt.get(fruits[left]) == 0) {
                    cnt.remove(fruits[left]);
                }
                ++left; // 左指针向右移动，缩小窗口
            }

            // 更新答案，计算当前窗口大小（即right - left + 1）
            ans = Math.max(ans, right - left + 1);
        }
        // 返回最终的最大水果数量
        return ans;
    }
}

//关键：该题很容易想到是滑动窗口，但难点在于如何量化类别数量，哈希表是一种很好的实现方法
//哈希表取键对应的值：get（如果表里原本就没有就用getOrDefault）；移除某对键值：remove；把某对键值放进表内：put
