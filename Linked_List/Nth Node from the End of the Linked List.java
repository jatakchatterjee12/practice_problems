/*
    Company Tags  :  Flipkart, Morgan Stanley, Accolite, Amazon, OYO Rooms, Samsung, Snapdeal, FactSet, Hike, MAQ Software, Adobe, Qualcomm, Epic Systems, Citicorp, Monotype Solutions
    GFG Link      :  https://www.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1
*/
class Solution
{
    int getNthFromLast(Node head, int n)
    {
        Node start = new Node(-1);
        start.next = head;
        
        Node fast = start;
        Node slow = start;
        
        for(int i=1; i<=n; i++) {
            if(fast != null)
                fast = fast.next;
        }
        
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow.data;
    }
}
