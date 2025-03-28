/* 
    Company Tags                : AMAZON
    Leetcode Link               : https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/
*/


/********************************************************************* C++ ************************************************************/
//Approach (Using Simple straight forward approach)
//T.C : O(n)
//S.C : O(n)
class Solution {
public:
    ListNode* modifiedList(vector<int>& nums, ListNode* head) {
        unordered_set<int> st(begin(nums), end(nums));
        ListNode* prev = NULL;
        ListNode* curr = head;


        while (curr != NULL && st.count(curr->val)) {
            head = curr->next;
            curr = head;
        }

        while (curr != NULL) {
            int currVal = curr->val;
            if (!st.count(currVal)) {
                prev = curr;
                curr = curr->next;
            } else {
                prev->next = curr->next;
                curr = curr->next;
            }
        }
        return head;
    }
};


/********************************************************************* JAVA ************************************************************/
//Approach (Using Simple straight forward approach)
//T.C : O(n)
//S.C : O(n)

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
    public ListNode modifiedList(int[] nums, ListNode head) {
        
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        // Handle the head
        while(head != null && set.contains(head.val)){
            head = head.next;
        }


        //
        ListNode curr = head;

        while(curr != null && curr.next != null ){
            if(set.contains(curr.next.val)){
                curr.next = curr.next.next;
            }
            else{
                curr = curr.next;
            }
        }

        return head;

    }
}


///////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Convert array to a set for O(1) lookup
        HashSet<Integer> st = new HashSet<>();
        for (int num : nums) {
            st.add(num);
        }

        // Skip the nodes at the start of the list that are present in the set
        while (head != null && st.contains(head.val)) {
            head = head.next;
        }

        // Now process the rest of the list
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            if (!st.contains(curr.val)) {
                // Move prev and curr forward
                prev = curr;
                curr = curr.next;
            } else {
                // Skip the current node
                if (prev != null) {
                    prev.next = curr.next;
                }
                curr = curr.next;
            }
        }

        return head;
    }
}
