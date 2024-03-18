/**/

//Approach : Using merge Sort
// TC - (Log(n)-> recursion tree height (every time split in two halves) *{(n ->call the merge func) + (n/2 -> for finding the middle)}
//TC - (O(n+n/2)log(n))

//SC - (logn) - > recursive stack space

class Solution {
    public ListNode sortList(ListNode head) {
        
        if(head == null || head.next == null) return head;

        ListNode slow_prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {

            slow_prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        slow_prev.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1, l2);
    }

    ListNode merge(ListNode l1, ListNode l2) {

        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode result = new ListNode(-1);
        ListNode curr = result;

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if(l1 != null) curr.next = l1;
        if(l2 != null) curr.next = l2;

        return result.next;
    }
}
