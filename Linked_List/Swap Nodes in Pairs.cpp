/*
    Company Tags                : Moonfrog Labs, Amazon, Microsoft
    Leetcode Link               : https://leetcode.com/problems/swap-nodes-in-pairs/
*/
//************************************** C++ *******************************************//
class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        if(!head || !head->next)
            return head;
        
        ListNode* nextNode = head->next;
        head->next = swapPairs(head->next->next);
        nextNode->next = head;
        return nextNode;
    }
};

//************************************ JAVA ***********************************************//
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
    public ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null) return head;

        // A - head
        // B - head.next
        // C - head.next.next
        // A->B->C->..

        ListNode temp = head.next; // storing B in temp
        head.next = swapPairs(head.next.next); // A->(C->..)
        temp.next = head; // B->A

        return temp;// returning B as new head
        
    }
}
