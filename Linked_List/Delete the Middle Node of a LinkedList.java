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
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        
        if(head == null || head.next == null) return null;
        ListNode slow_prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow_prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode slow_next = slow.next;
        slow.next = null;
        slow_prev.next = slow_next;

        return head;
    }
}
