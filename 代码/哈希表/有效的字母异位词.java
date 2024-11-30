package 哈希表;

class Solution {
    public boolean isAnagram(String s, String t) {
        int [] record = new int[26];
        for(int i = 0; i < s.length(); i++){
            record[s.charAt(i) - 'a']++;
        }
        for(int j = 0; j < t.length(); j++){
            record[t.charAt(j) - 'a']--;
        }
        for(int count: record){
            if(count != 0) return false;
        }
        return true;
    }
}

//用数组做哈希表，s中遇到的字符就把对应位置的值+1，t中遇到的字符就把对应位置的值-1，最后看数组哈希表各元素值是否为0
//如果s和t是异位词，那么哈希表中的每个值一定为0，否则就不是异位词
