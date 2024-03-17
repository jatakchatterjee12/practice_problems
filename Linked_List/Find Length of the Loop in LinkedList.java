public class Solution
{
    public static int lengthOfLoop(Node head) {
       
        if(head == null || head.next == null) return 0;

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            // cycle exists
            if(slow == fast) {
                return countNode(slow);
            }
        }
        return 0;
    }

    static int countNode(Node head) {

        Node temp = head;
        int res = 1;

        while(temp.next !=  head) {
            temp = temp.next;
            res++;
        }

        return res;
    }
}
