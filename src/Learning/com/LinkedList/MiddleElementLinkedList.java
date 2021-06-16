package Learning.com.LinkedList;


public class MiddleElementLinkedList {
    public static void main(String[] args) {
        ListNode Head = new ListNode(1);
        Head.next = new ListNode(2);
        Head.next.next = new ListNode(3);
        Head.next.next.next = new ListNode(4);
        Head.next.next.next.next = new ListNode(5);

        System.out.println(Solve(Head));
    }

    public static int Solve(ListNode A){
        ListNode Slow = A;
        ListNode Fast = A;

        while(Fast!=null && Fast.next!=null){
            Fast = Fast.next.next;
            Slow = Slow.next;

        }

        return Slow.Val;
    }
}
