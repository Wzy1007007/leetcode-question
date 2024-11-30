package 哈希表;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int slen = s.length();
        int plen = p.length();

        if(slen < plen) return new ArrayList<Integer>();

        int [] scount = new int[26];
        int [] pcount = new int[26];
        List<Integer> ans = new ArrayList<Integer>();

        for(int i = 0; i < p.length(); i++){
            scount[s.charAt(i) - 'a']++;
            pcount[p.charAt(i) - 'a']++;
        }

        if(Arrays.equals(scount, pcount)){
            ans.add(0);
        }

        for(int j = 0; j < s.length() - p.length(); j++){
            scount[s.charAt(j) - 'a']--;
            scount[s.charAt(j + p.length()) - 'a']++;
            if(Arrays.equals(scount, pcount)){
                ans.add(j + 1);
            }
        }

        return ans;

    }
}
