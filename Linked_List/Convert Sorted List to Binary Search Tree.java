/*
    Company Tags                : Google, Flipkart, Amazon
    Leetcode Link               : https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
*/

/*
Time complexity: O(n log(n)).
There are log(n) recursive levels because each time we split it to half, and in each level we loop through the whole list, divided into small parts.
Space complexity: O(log(n)).
We don't consider the returning tree as extra space, but we have log(n) recursive calls on stack.
*/
//****************************************** C++ ********************************************8//
class Solution {
public:
    TreeNode* sortedListToBST(ListNode* head) {
        if(!head)
            return NULL;
        if(!head->next)
            return new TreeNode(head->val);
        
        //Find mid and make it root
        ListNode* slow = head;
        ListNode* fast = head;
        ListNode* slow_prev = NULL;
        while(fast && fast->next) {
            slow_prev = slow;
            slow = slow->next;
            fast = fast->next->next;
        }
        
        
        TreeNode* root = new TreeNode(slow->val); //Make root
        slow_prev->next = NULL; //We only want left half of linked list for left subtree
        
        root->left  = sortedListToBST(head);       //Make left subtree
        root->right = sortedListToBST(slow->next); //Make right subtree
        
        return root; //return root
        
    }
};

//********************************************** JAVA *****************************************************//
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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);

        ListNode slow = head;
        ListNode fast = head;
        ListNode slow_prev = null;

        while(fast != null && fast.next != null){

            slow_prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //slow points to the middle
        TreeNode root = new TreeNode(slow.val); // middle should be the root as it is height balanced

        slow_prev.next = null; //disconnect the left half

        root.left = sortedListToBST(head); // left half ka head
        root.right = sortedListToBST(slow.next); // right half ka head 

        return root;
    }
}

//Approach 2 : MAking a List of LNode and make a BST out of that List
//Tc - O(n)
//sc -O(n)

/*Linked List Node
class LNode
{
    int data;
    LNode next;
    LNode(int d) {
        data = d; 
        next = null;
    }
}

//Tree Node
class TNode
{
    int data;
    TNode left, right;
    TNode(int x)
    {
        data=x;
        left=right=null;
    }
    
}*/

class Solution
{
    TNode BuildBST(List<Integer> Tree, int start, int end) {
        
        if(start > end){
            return null;
        }
        
        int mid = start + (end- start + 1)/2;
        TNode root = new TNode(Tree.get(mid));
        
        root.left = BuildBST(Tree, start, mid-1);
        root.right = BuildBST(Tree, mid+1, end);
        
        return root;
    }
    public TNode sortedListToBST(LNode head)
    {
        
        List<Integer> Tree = new ArrayList<>();
        while(head != null){
            Tree.add(head.data);
            head = head.next;
        }
        
        return BuildBST(Tree, 0, Tree.size()-1);
    }
}
