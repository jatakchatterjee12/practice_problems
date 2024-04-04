/*
    Company Tags                : VMWare, Amazon, Uber, Google, Twitter, LinkedIn, Airbnb, Facebook, Microsoft, IXL
    Leetcode Link               : https://leetcode.com/problems/merge-k-sorted-lists/
*/

//**************************************************** C++ ************************************************************************//

//Approach-1 (Using merge sort) - Time : O(log(k) * k * n)
/*
    Where k = total number of lists
    and n = average length of every linkedlist
    Why ?
    Because, The merge in the higher layer has more nodes, 
    the lists are longer than the lists in the bottoms. 
    But the number of operation of merge is the same in every level(which is k*n). 
    and log(k) comes from "partitionAndMerge" function. We will have log(k) levels and on each level we do a merge.
*/
class Solution {
public:
    ListNode* mergeTwoSortedLists(ListNode* l1, ListNode* l2) {
        if(!l1)
            return l2;
        if(!l2)
            return l1;

        if(l1->val <= l2->val) {
            l1->next = mergeTwoSortedLists(l1->next, l2);
            return l1;
        } else {
            l2->next = mergeTwoSortedLists(l1, l2->next);
            return l2;
        }
        
        return NULL;
    }
    
    ListNode* partitionAndMerge(int start, int end, vector<ListNode*>& lists) {
        if(start == end)
            return lists[start];
        
        if(start > end)
            return NULL;
        
        int mid = start + (end-start)/2;
        
        ListNode* l1 = partitionAndMerge(start, mid, lists);
        ListNode* l2 = partitionAndMerge(mid+1, end, lists);
        
        return mergeTwoSortedLists(l1, l2);
    }
    
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        
        int n = lists.size();
        
        if(n == 0)
            return NULL;
        
        return partitionAndMerge(0, n-1, lists);
        
    }
};



//Approach 2: Using Min Heap
//TC - O(n* k* log(k))

/*
struct Node
{
	int data;
	Node* next;
	
	Node(int x){
	    data = x;
	    next = NULL;
	}
	
};
*/ 

class Solution{
  public:
  
    class Compare{
        public:
            bool operator()(Node* a, Node* b) {
                return a->data > b->data;
            }
    };
    
    
    //Function to merge K sorted linked list.
    Node * mergeKLists(Node *arr[], int K)
    {
        priority_queue<Node*, vector<Node*> ,  Compare > pq(arr, arr + K);
        
        Node* dummy = new Node(0);
        Node* tail = dummy;
        
        Node* temp;
        
        while(!pq.empty()) {
            
            temp = pq.top();
            pq.pop();
            
            tail->next = temp;
            tail = tail->next;
            
            if(temp->next){
                pq.push(temp->next);
            }
        }
        
        return dummy->next;
        
        
    }
};


//******************************************************** JAVA *******************************************************************//
//Approach-1 (Using merge sort) - Time : O(log(k) * k * n)
/*
    Where k = total number of lists
    and n = average length of every linkedlist
    Why ?
    Because, The merge in the higher layer has more nodes, 
    the lists are longer than the lists in the bottoms. 
    But the number of operation of merge is the same in every level(which is k*n). 
   and log(k) comes from "partitionAndMerge" function. We will have log(k) levels and on each level we do a merge.
*/
class Solution {
    ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    ListNode partitionAndMerge(int start, int end, ListNode[] lists){
        if(start > end){
            return null;
        }

        if(start == end){
            return lists[start];
        }

        int mid = start + (end-start)/2;
        ListNode L1 = partitionAndMerge(start, mid, lists);
        ListNode L2 = partitionAndMerge(mid+1, end, lists);

        return mergeTwoLists(L1, L2);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if(k == 0) return null;

        return partitionAndMerge(0, k-1, lists);
    }
}


////Approach 2: Using Min Heap
//TC - O(n* k* log(k))
class Solution
{
    //Function to merge K sorted linked list.
    Node mergeKList(Node[]arr,int K)
    {
       
       PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> a.data - b.data);
       
       for(Node i : arr){
           pq.add(i);
       }
       
       Node dummy = new Node(0);
       Node tail = dummy;
       
       Node temp;
       
       while(!pq.isEmpty()) {
           
           temp = pq.poll();
           
           tail.next = temp;
           tail = tail.next;
           
           if(temp.next != null){
               pq.add(temp.next);
           }
       }
       
       return dummy.next;
    }
}
