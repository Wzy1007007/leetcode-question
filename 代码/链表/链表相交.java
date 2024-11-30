package 链表;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA != pB){
            if(pA == null){
                pA = headB;
            }
            else{
                pA = pA.next;
            }
            if(pB == null){
                pB = headA;
            }
            else{
                pB = pB.next;
            }
        }
        return pA;
    }
}

//双指针一个从a1走向c3，走完后跳到b1；另一个从b1走向c3，走完后跳到a1
//如果if判断条件写pA.next/pB.next，当链表无相交时会进入死循环
//换言之我们需要pA/pB到链表尽头后进入null阶段再回到起点，让循环及时退出（若无相交，两个指针同时为空），这种写法能被有相交/无相交的情况通吃
