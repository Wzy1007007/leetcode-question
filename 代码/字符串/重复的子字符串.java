package 字符串;

class Solution {
    void getNext (int[] next, String s){
        next[0] = 0;
        int j = 0;
        for(int i = 1; i < s.length(); i++){
            while(j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if(s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
    }

    public boolean repeatedSubstringPattern (String s) {
        if (s.length() == 0) {
            return false;
        }
        int len = s.length();
        int [] next = new int[len];
        getNext(next, s);
        if (next[len - 1] != 0 && len % (len - (next[len - 1] )) == 0) {
            return true;
        }
        return false;
    }
};
