 /*
    Qn. Given the head of a linked list, rotate the list to the right by k places.
    Input: head = [1,2,3,4,5], k = 2
    Output: [4,5,1,2,3]

    Input: head = [0,1,2], k = 4
    Output: [2,0,1]
 */

/*
  Approach ---------------- 1. Get the length of the list
                            2. connect tail and head, make a circular List
                            3.Make the pointer to the (len-k)th node of the list , that gonna be the last node of your answer List(P1)
                            4.the new head will be the (len-k + 1)th node(newHead = p1.next)
                            5.Make the end of the list(p1.next = null)  and return newHead
*/

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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)return head;

        int len=1;
        ListNode p1 = head;
        ListNode newHead = head;

        while(p1.next != null){ // 1. get the total length of the list
            p1 = p1.next;
            len++;
        }
        p1.next = head; // 2. circle the link ---> 1->2->3->4->5->6------

        k = k%len;
        if(k != 0){
            for(int i=0; i<(len-k); i++){
                p1 = p1.next; // 3. p1 node is the (len-k)th node (1st node is head);
            }
        }   

        newHead = p1.next; // 4. newHead -> p1.next
        p1.next = null; // 5. make the end and return newHead
        return newHead;
    }
}
