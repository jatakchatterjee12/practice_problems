//Optimal Solution

public class Solution
{
    public static Node segregateEvenOdd(Node head)
    {
       if(head == null || head.next == null) return head;

       Node evenHead = new Node(-1);
       Node oddHead  = new Node(-1);

       Node odd = oddHead;
       Node even = evenHead;

       Node temp = head;

       while(temp != null) {
           if(temp.data % 2 == 0){
               even.next = temp;
               even = even.next;
           }
           else{
               odd.next = temp;
               odd = odd.next;
           }

           temp = temp.next;
       }

       even.next = oddHead.next;
       odd.next = null;

       return evenHead.next;
       
    }
}
