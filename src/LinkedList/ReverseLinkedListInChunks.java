package Learning.com.LinkedList;

import java.util.ArrayList;
import java.util.List;

// I.P  - [1,2,3,4,5,6]
// Reverse Linked List Between  B =2 to C = 4 Nodes
// O.P  - [1,4,3,2,5,6]


public class ReverseLinkedListInChunks {
    public static void main(String[] args) {
        ListNode Head = new ListNode(1);
        Head.next = new ListNode(2);
        Head.next.next = new ListNode(3);
        //Head.next.next.next = new ListNode(4);
        //Head.next.next.next.next = new ListNode(5);

        ListNode Result = Solve(Head, 1, 2);

        ArrayList<Integer> A1 = new ArrayList<>();
        while (Result!=null){
            A1.add(Result.Val);
            Result = Result.next;
        }
        System.out.println(A1);
    }

    public static  ListNode Solve(ListNode A, int B , int C){
        ListNode BeforeNodes = null;
        ListNode AfterNodes = null;
        ListNode BNode = null;
        ListNode CNode = null;
        ListNode CurrentNode = A;

        int i=0;
        while (CurrentNode!=null){
            i++;
            if (i<B){
                BeforeNodes = CurrentNode;
            }
            if (i==B){
                BNode = CurrentNode;
            }
            if (i==C){
                CNode = CurrentNode;
                AfterNodes = CurrentNode.next;
            }
            CurrentNode = CurrentNode.next;
        }

        CNode.next =null;
        //Reverse LinkedList from B to C
        CurrentNode = ReverseTheLinkedList.Solve(BNode);

        if (AfterNodes!=null) BNode.next = AfterNodes;
        if (BeforeNodes!=null){
            BeforeNodes.next = CurrentNode;
            return A;
        }
        return CurrentNode;
    }



}
