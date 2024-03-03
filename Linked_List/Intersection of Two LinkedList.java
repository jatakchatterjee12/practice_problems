//Approach  1 : Brute Force --> comaparing each node of l1 with each node of l2 
//TC : O(m*n) m = size of l1 , n = size of l2



//Approach 2 : Better --> Using hashset to store node 
//TC : O(m + n)
//SC : O(m)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> hs = new HashSet<>();

        ListNode t1 = headA;
        while(t1 != null) {
            hs.add(t1);
            t1 = t1.next;
        }

        ListNode t2 = headB;
        while(t2 != null) {
            if(hs.contains(t2)) return t2;
            hs.add(t2);
            t2 = t2.next;
        }
        return null;
    }
}

//Approach 3 : Most Optimized Solution
// TC : O(2*m) // worst condition if the intersection point be at last
//SC : O(1)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        while(a != b) {
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;

        }

        return a ; // or b
    }
}
