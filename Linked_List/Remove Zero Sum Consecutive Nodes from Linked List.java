/*
    Company Tags                : NA
    Leetcode Link               : https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
*/


/******************************************************************** C++ ********************************************************************/
//T.C : O(n^2)
//S.C : O(n) - We took a map
class Solution {
public:
    ListNode* removeZeroSumSublists(ListNode* head) {
        int prefixSum = 0;
        unordered_map<int, ListNode*> mp;
        
        ListNode* dummy = new ListNode(0);
        dummy->next = head;
        mp[0] = dummy;
        
        
        
        while(head) {
            prefixSum += head->val;
            
            if(mp.find(prefixSum) != mp.end()) {
                
                ListNode* P     = mp[prefixSum];
                ListNode* start = P;
                int pSum        = prefixSum;
                
                while(start != head) {
                    
                    start = start->next;
                    pSum += start->val;
                    if(start != head)
                        mp.erase(pSum);
                }
                
                P->next = start->next;
                
            } else {
                mp[prefixSum] = head;
            }
            
            head = head->next;
        }
        
        return dummy->next;
    }
};



/******************************************************************** JAVA ********************************************************************/
//T.C : O(n^2)
//S.C : O(n) - We took a map
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int prefixSum = 0;

        Map<Integer, ListNode> mp = new HashMap<>();
        mp.put(0, dummy);

        while(head != null) {

            prefixSum += head.val;

            if(mp.containsKey(prefixSum)) {

                ListNode start = mp.get(prefixSum);
                ListNode temp = start;

                int deleteSum = prefixSum;

                while(temp != head) {
                    temp = temp.next;

                    deleteSum += temp.val;

                    if(temp != head) {
                        mp.remove(deleteSum);
                    }
                }

                start.next = head.next;
            }
            else {
                mp.put(prefixSum, head);
            }

            head = head.next;
        }

        return dummy.next;
    }
}
