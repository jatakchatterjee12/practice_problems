/*
    Company Tags     : Amazon, Microsoft, Samsung, Visa, Goldman Sachs, Kritikal Solutions
    Leetcode link    : https://leetcode.com/problems/delete-node-in-a-linked-list/
    GFG Link         : https://www.geeksforgeeks.org/problems/delete-without-head-pointer/1
*/

//TC - O(1);
//SC - O(1)

class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
