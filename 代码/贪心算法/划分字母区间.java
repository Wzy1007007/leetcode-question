package 贪心算法;

class Solution {
    public List<Integer> partitionLabels(String s) {
        int hash[] = new int[26];
        List<Integer> res = new ArrayList();
        int rightmost = 0;
        int last = -1;
        for(int i = 0; i < s.length(); i++){
            hash[s.charAt(i) - 'a'] = i;
        }
        for(int i = 0; i < s.length(); i++){
            rightmost = Math.max(rightmost, hash[s.charAt(i) - 'a']);
            if(i == rightmost){
                res.add(i - last);
                last = i;
            }
        }
        return res;
    }
}
