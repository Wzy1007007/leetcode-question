package 数组;

class Solution {
    public String minWindow(String s, String t) {
       if (s == null || s.isEmpty() || t == null || t.isEmpty() || s.length() < t.length()) return "";

       Map<Character, Integer> need = new HashMap<Character, Integer>();  //记录t中每个字符出现次数
       Map<Character, Integer> window = new HashMap<Character, Integer>();  //记录s中每个字符出现次数

       for (char c : t.toCharArray()){
           need.put(c, need.getOrDefault(c, 0) + 1);
       }
       
       int left = 0, right = 0; // 窗口的左右边界
       int valid = 0; // 已经匹配上的字符数量（既依赖字符种类，也依赖字符出现的次数）
       int start = 0, minLen = Integer.MAX_VALUE; // 最小窗口的起始位置和长度

       while (right < s.length()) {
           char r = s.charAt(right);
           right++;

           // 更新窗口内字符的计数
           if (need.containsKey(r)) {  //r字符包含在need哈希表里面才把它加入window
               window.put(r, window.getOrDefault(r, 0) + 1);
               if (window.get(r).equals(need.get(r))) valid++;
           }

           // 当窗口内的字符已经完全包含了 t 中的所有字符时
           while (valid == need.size()) {
               // 更新最小窗口的起始位置和长度
               if (right - left < minLen) {
                   start = left;
                   minLen = right - left;
               }

               char l = s.charAt(left);
               // 缩小窗口，移动左边界
               if (need.containsKey(l)) {
                   window.put(l, window.get(l) - 1);
                   if (window.get(l) < need.get(l)) valid--;
               }
               left++;
           }
       }
       return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
   }
}

//和水果成篮类似，需要维护哈希表存储字母（即类别）的数量