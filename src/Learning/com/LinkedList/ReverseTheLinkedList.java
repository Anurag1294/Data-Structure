package Learning.com.LinkedList;


import java.util.ArrayList;

public class ReverseTheLinkedList {
    public static void main(String[] args) {
        ListNode Head = new ListNode(1);
        Head.next = new ListNode(2);
        Head.next.next = new ListNode(3);
        Head.next.next.next = new ListNode(4);
        Head.next.next.next.next = new ListNode(5);

        ListNode Result = Solve(Head);

        ArrayList<Integer> A1 = new ArrayList<>();
        while (Result!=null){
            A1.add(Result.Val);
            Result = Result.next;
        }
        System.out.println(A1);
    }

    public static ListNode Solve(ListNode A){
        ListNode PreviousNode = null;
        ListNode NextNode = A;
        ListNode CurrentNode =A;

        while(NextNode!=null){
            NextNode = CurrentNode.next;
            CurrentNode.next = PreviousNode;
            PreviousNode = CurrentNode;
            CurrentNode = NextNode;
        }

        return PreviousNode;
    }
}
