package 哈希表;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 创建一个哈希表，键为排序后的字符串，值为原始字符串的列表
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        // 遍历输入的字符串数组
        for (String str : strs) {
            // 将当前字符串转换为字符数组
            char[] array = str.toCharArray();
            // 对字符数组进行排序
            Arrays.sort(array);
            // 将排序后的字符数组转换回字符串，作为哈希表的键
            String key = new String(array);
            // 从哈希表中获取与键对应的列表，如果不存在则创建一个新的列表
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            // 将当前字符串添加到列表中
            list.add(str);
            // 将更新后的列表放回哈希表中
            map.put(key, list);
        }
        
        // 将哈希表中的所有值（即所有列表）转换为一个列表并返回
        List<List<String>> arrays = new ArrayList<List<String>>(map.values());
        return arrays;
    }
}

//熟悉哈希表各种功能的写法
