package 链表;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 //两趟扫描
 class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        ListNode cur = dummyhead;
        ListNode temp = dummyhead;
        int size = 0;
        while(temp.next != null){
            temp = temp.next;
            size++;
        }
        for(int i = 0; i < size - n; i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummyhead.next;
    }
}

//一趟扫描：双指针
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        ListNode fast = dummyhead;
        ListNode slow = dummyhead;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        while(fast.next != null){ //仅这一次扫描
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyhead.next;
    }
}
