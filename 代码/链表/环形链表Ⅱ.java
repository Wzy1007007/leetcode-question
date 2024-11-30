package 链表;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
               return null;   //也可以写break
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}

//关键点：判断是否有环 && 环的入口在哪里
//判断是否有环：fast指针为空，必没有环
//快指针（一次走两步）一定会追上慢指针（一次走一步），不存在跳步，因此有环说明fast一定能追上slow
//快指针追上慢指针时，慢指针一定没有走完一圈
//相遇后快指针回到head一次走一步，走到环的入口时刚好追上慢指针（基于a=c+(n-1)(b+c)等式）
//一定要画图!
