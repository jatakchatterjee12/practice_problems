// 1.find mid
// 2. reverse the second half
// 3 find the max result


//Approach - call the reverse func recursively
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
    public int pairSum(ListNode head) {
        
        // find mid
        ListNode mid = findMid(head);

        //Reverse the second half
       /* ListNode prev = null;
        ListNode nxt = null;

        while(mid != null) {
            nxt = mid.next;
            mid.next = prev;
            prev = mid;
            mid = nxt;
        } */

        mid = reverse(mid);

        //find max result;
        int result= 0 ;
        ListNode curr = head;

        while(mid != null) {
            int sum = curr.val + mid.val;
            result = Math.max(result, sum);
            curr = curr.next;
            mid = mid.next;
        }

        return result;
    }

    ListNode findMid(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    ListNode reverse(ListNode h) {
        if(h == null || h.next == null) return h;
        ListNode last = reverse(h.next);
        h.next.next = h;
        h.next = null;
        return last;
    }
}

//Approach
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

    ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast!= null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public int pairSum(ListNode head) {
        
        // find mid node 
        // reverse 2nd half of LL
        // curr = head   
        // mid  =  starting of 2nd half LL
        // while(mid!=null){
           // val = curr.val + mid.val
           // max(result, val)
           //curr =crr.next 
           //mid = mid.next
        //}

        // 1. find mid 

         ListNode mid = findMid(head);

        // 2. Reverse the 2nd half of the LL
         ListNode prev = null;
         ListNode next = null;
         
         while(mid!= null){

             next = mid.next;
             mid.next = prev;
             prev = mid;
             mid = next;
         }

         // 3. Find Max result
         int result = 0;

         ListNode curr = head;

         while(prev != null){
             int sum = curr.val + prev.val;
             result = Math.max(result,sum);
             curr = curr.next;
             prev = prev.next;
         }

         return result;

    }
}
