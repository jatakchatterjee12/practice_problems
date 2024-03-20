// 2 pass solution
public class Solution
{
    public static Node sortList(Node head) {
        // Write your code here

        if(head == null || head.next == null) return head;

        int cnt0 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        Node temp = head;

        while(temp != null) {
            if(temp.data == 0) cnt0++;
            else if(temp.data == 1) cnt1++;
            else cnt2++;

            temp = temp.next;
        }

        temp = head;
        while(temp != null) {

            if(cnt0 > 0){
                temp.data = 0;
                cnt0--;
            }
            else if(cnt1 > 0){
                temp.data = 1;
                cnt1--;
            }
            else {
                temp.data = 2;
                cnt2--;
            }

            temp = temp.next;
        }

        return head;

    }
}

// 1 pass Solution
public class Solution
{
    public static Node sortList(Node head) {
        // Write your code here

        if(head == null || head.next == null) return head;

        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);

        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;

        Node temp = head;

        while(temp != null){

            if(temp.data == 0){
                zero.next = temp;
                zero = zero.next;
            }
            else if(temp.data == 1){
                one.next = temp;
                one = one.next;
            }
            else {
                two.next = temp;
                two = two.next;
            }

            temp = temp.next;
        }

        zero.next = (oneHead.next != null)? oneHead.next : twoHead.next;
        one.next  = twoHead.next;
        two.next  = null;

        Node newHead = zeroHead.next;

        return newHead;
    }
}
