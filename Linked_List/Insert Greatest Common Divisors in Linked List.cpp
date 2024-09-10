/*  
    Company Tags                : will update soon
    Leetcode Link               : https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list
*/


/********************************************************************* C++ ************************************************************/
//Approach-1 (Iterative)
//T.C : O(n)
//S.C : O(1)
class Solution {
public:
    ListNode* insertGreatestCommonDivisors(ListNode* head) {
        if(!head || !head->next) {
            return head;
        }

        ListNode* currNode = head;
        ListNode* nextNode = head->next;

        while(nextNode) {
            ListNode* temp = new ListNode(__gcd(currNode->val, nextNode->val));

            currNode->next = temp;
            temp->next     = nextNode;

            currNode = nextNode;
            nextNode = nextNode->next;
        }

        return head;
    }
};


//Approach-2 (Recursion Story)
//T.C : O(n)
//S.C : System stack space due to recursion O(n)
class Solution {
public:
    ListNode* insertGreatestCommonDivisors(ListNode* head) {
        // Base case: if head is null or there's only one node, return head.
        if (!head || !head->next) {
            return head;
        }

        // Recursively process the rest of the list
        ListNode* temp = insertGreatestCommonDivisors(head->next);

        // Create a new node with the GCD of current and next node values
        ListNode* gcdNode = new ListNode(__gcd(head->val, head->next->val));

        // Insert the new node between the current node and the next node
        gcdNode->next = temp;
        head->next = gcdNode;

        // Return the current node
        return head;
    }
};


/********************************************************************* JAVA ************************************************************/
//Approach-1 (Iterative)
//T.C : O(n)
//S.C : O(1)
class Solution {

    private int gcd(int x, int y) {
        if(y == 0){
            return x;
        }
        return gcd(y, x%y);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        
        if(head == null || head.next == null) {
            return head;
        }

        ListNode curr = head;

        while(curr.next != null) {

            ListNode nextNode = curr.next;

            int num1 = curr.val;
            int num2 = nextNode.val;

            ListNode node = new ListNode(gcd(num1, num2));

            curr.next = node;
            node.next = nextNode;

            curr = curr.next.next;

        }

        return head;
    }
}
       


//Approach-2 (Recursion Story)
//T.C : O(n)
//S.C : System stack space due to recursion O(n)
class Solution {
    // Helper method to calculate GCD of two numbers
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        // Base case: if the list is empty or has only one element, return the head as is
        if (head == null || head.next == null) {
            return head;
        }

        // Insert the GCD node recursively
        ListNode temp = insertGreatestCommonDivisors(head.next);

        // Create a new node with the GCD of current and next node values
        ListNode gcdNode = new ListNode(gcd(head.val, head.next.val));
        
        // Insert the new node between current node and next node
        gcdNode.next = temp;
        head.next = gcdNode;

        return head;
    }
}
