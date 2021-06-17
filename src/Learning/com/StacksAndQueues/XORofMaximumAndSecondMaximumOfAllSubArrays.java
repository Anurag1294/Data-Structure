package Learning.com.StacksAndQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class XORofMaximumAndSecondMaximumOfAllSubArrays {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2,3,4,1,5));
        System.out.println(Solve(A));
    }

    public static int Solve(ArrayList<Integer> A){
        int N = A.size();
        Stack<Integer> S = new Stack<>();
        int Result=0;
        for(int i=0;i<N;i++){

            while (!S.empty()){

                Result = Math.max(Result, A.get(S.peek())^A.get(i));

                if (A.get(S.peek()) > A.get(i)) break;

                S.pop();

            }

            S.push(i);
        }
        return Result;
    }
}
