package 哈希表;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int [] record = new int[26];
        for(int i = 0; i < magazine.length(); i++){
            record[magazine.charAt(i) - 'a']++;
        } 
        for(int j = 0; j < ransomNote.length(); j++){
            record[ransomNote.charAt(j) - 'a']--;
            if(record[ransomNote.charAt(j) - 'a'] < 0) return false;
        }
        // for(int count: record){
        //     if(count < 0) return false;
        // }
        return true;
    }
}

//本质也是字母异位词
//判断record的元素有没有为负，可以在第二个循环对record相应未知元素操作后直接判断（节省时间）
//关键是看ransomNote出现的字母能否在magazine都找到且数量匹配（不管magazine中字母出现的顺序）
