package 哈希表;

class Solution {
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }

        //退出循环的条件为n=1或n在哈希表中有查找到
        return (n == 1);
    }
}


//统计sum用getNext函数，注意逻辑和写法
//可能出现死循环的情况，需要设置合适条件退出循环
//（即哈希表之前储存的sum再次出现，所以哈希表中的数据不重复，因此想到set型哈希表）