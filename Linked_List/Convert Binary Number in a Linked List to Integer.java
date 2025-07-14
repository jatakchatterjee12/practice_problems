/*     
    Company Tags                : Will update soon
    Leetcode Link               : https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer
*/


/************************************************************ C++ *****************************************************/
//Approach-1 (Reversing the linkedList and then computing)
//T.C : O(n)
//S.C : O(1), Ignoring Recursion stack space occupied during reversal of LinkedList
class Solution {
public:
    ListNode* reverseLL(ListNode* head) {
        if(head == NULL || head->next == NULL) {
            return head;
        }

        ListNode* last = reverseLL(head->next);
        head->next->next = head;
        head->next = NULL;
        return last;
    }

    int getDecimalValue(ListNode* head) {
        head= reverseLL(head);

        int result = 0;
        int power = 0;
        while(head) {
            if(head->val == 1) {
                result += pow(2, power);
            }
            power++;
            head = head->next;
        }

        return result;
    }
};



//Approach-2 (Using bit manipulation to form the decimal number)
//T.C : O(n)
//S.C : O(1)
class Solution {
public:
    int getDecimalValue(ListNode* head) {
        int result = 0;

        while(head) {
            result = (result << 1) | (head->val);

            head = head->next;
        }        
        return result;
    }
};




/************************************************************ JAVA *****************************************************/
//Approach-1 (Reversing the linkedList and then computing)
//T.C : O(n)
//S.C : O(1), Ignoring Recursion stack space occupied during reversal of LinkedList
class Solution {
    
    private ListNode reverseLL(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode last = reverseLL(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
    
    public int getDecimalValue(ListNode head) {
        head = reverseLL(head);
        
        int result = 0;
        int power = 0;

        while(head != null) {
            if(head.val == 1) {
                result += Math.pow(2, power);
            }
            power++;
            head = head.next;
        }

        return result;
    }
}

//Approach-1 (Reversing the linkedList in iterative manner and then computing)
//T.C : O(n)
//S.C : O(1), Ignoring Recursion stack space occupied during reversal of LinkedList
class Solution {
    private ListNode reverseLL(ListNode head){

        if(head == null || head.next == null){
            return head;
        }

        ListNode curr = head;
        ListNode next;
        ListNode prev = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public int getDecimalValue(ListNode head) {
        
        head = reverseLL(head);

        int ans  = 0;
        int point = 0;


        while(head != null){

            if(head.val == 1){
                ans += Math.pow(2,point);
            }
            point++;
            head = head.next;
        }

        return ans;
    }
}

//Approach-2 (Using bit manipulation to form the decimal number)
//T.C : O(n)
//S.C : O(1)
class Solution {

    public int getDecimalValue(ListNode head) {
        int result = 0;
        while(head != null) {
            result = (result << 1) | head.val;
            head = head.next;
        }
        return result;
    }
}
