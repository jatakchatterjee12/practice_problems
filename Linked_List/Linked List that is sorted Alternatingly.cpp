/*
    GFG Link            :  https://www.geeksforgeeks.org/problems/linked-list-that-is-sorted-alternatingly/1
    Company Tags        : Amazon
*/

//************************************************* C++ *********************************************************************/

/*
struct Node
{
	int data;
	struct Node *next;
	
	Node(int x){
	    data =x;
	    next = NULL;
	}
};
*/

class Solution
{
    public:
    
    Node *merge(Node* l1, Node* l2){
        if(!l1)return l2;
        if(!l2) return l1;
        
        Node *temp;
        if(l1->data < l2->data){
            temp = l1;
            l1->next = merge(l1->next, l2);
        }
        else{
            temp = l2;
            l2->next = merge(l1, l2->next);
        }
        return temp;
    }
    
    void reverse(Node *&head) {
        Node* prev = NULL;
        Node* curr = head;
        Node* next;
        
        while(curr) {
            
            next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }
        
        head = prev;
    }
    
    void splitList(Node *head, Node **Ahead, Node **Dhead) {
        
        *Ahead = new Node(0);
        *Dhead = new Node(0);
        
        Node* ascn = *Ahead;
        Node* dscn = *Dhead;
        
        Node* curr = head;
        
        while(curr) {
            ascn->next = curr;
            curr = curr->next;
            ascn = ascn->next;
            
            if(curr){
                dscn->next = curr;
                curr = curr->next;
                dscn = dscn->next;
            }
        }
        
        ascn->next = NULL;
        dscn->next = NULL;
        
        *Ahead = (*Ahead)->next;
        *Dhead = (*Dhead)->next;
        
        return;
    }
    // your task is to complete this function
    void sort(Node **head)
    {
         // Code here
         
        Node *Ahead, *Dhead;
        
        splitList(*head, &Ahead, &Dhead);
        
        reverse(Dhead);
        
        *head = merge(Ahead, Dhead);
        
        
    }
};


//*************************************************** JAVA **************************************************************************8//



/*
class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {
    
    Node merge(Node l1, Node l2) {
        
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        Node temp = new Node(-1);
        
        if(l1.data < l2.data){
            temp = l1;
            l1.next = merge(l1.next, l2);
        }
        else {
            temp = l2;
            l2.next = merge(l1, l2.next);
        }
        
        return temp;
    }
    
   /* void reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;
        
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        head = prev;
    }

    */
    
    /* void splitHead(Node head, Node Ahead, Node Dhead) {
        
         Ahead = new Node(0);
         Dhead = new Node(0);
        
        Node ascn = Ahead;
        Node dscn = Dhead;
        Node curr = head;
        
        while(curr != null) {
            ascn.next = curr;
            
            curr = curr.next;
            ascn = ascn.next;
            
            if(curr != null) {
                dscn.next = curr;
                
                curr = curr.next;
                dscn = dscn.next;
            }
        }
        
        ascn.next = null;
        dscn.next = null;
        
        Ahead = Ahead.next;
        Dhead = Dhead.next;
        
        return;
    }
*/
    
   public Node sort(Node head){
       
       Node Ahead = new Node(0), Dhead = new Node(0);
       
       Node curr = head, ascn = Ahead, dscn = Dhead;
       
       while(curr != null) {
           ascn.next = curr;
           curr = curr.next;
           ascn = ascn.next;
           
           if(curr != null) {
               dscn.next = curr;
               curr = curr.next;
               dscn = dscn.next;
           }
       }
       
       ascn.next = null;
       dscn.next = null;
       
       Ahead = Ahead.next;
       Dhead = Dhead.next;
       
       
       //splitHead(head, Ahead, Dhead);
       
       //reverse(Dhead);
       dscn = Dhead;
       Node prev = null;
       Node curr2 = dscn;
       Node next;
       
       while(curr2 != null) {
           next = curr2.next;
           curr2.next = prev;
           prev = curr2;
           curr2 = next;
       }
       
       Dhead = prev;
       
       head = merge(Ahead, Dhead);
       
       return head;
   }


}
