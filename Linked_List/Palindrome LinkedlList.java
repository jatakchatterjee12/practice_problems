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
    public boolean isPalindrome(ListNode head) {
        
        if(head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        //find the prev node of the middle of the  list
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }
        
        //reverse the right half
        slow.next = reverse(slow.next);

        //move the slow pointer to the right half
        slow = slow.next;

        //now check if the both half have equal values or not

        while(slow != null) {
            if(head.val != slow.val){
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    
    }
    ListNode reverse(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode last = reverse(head.next);

        head.next.next = head;
        head.next = null;

        return last;
    }
}
