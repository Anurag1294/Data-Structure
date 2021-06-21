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
                    //Store the maximum XOR
                    Result = Math.max(Result, A.get(S.peek())^A.get(i));
                    // If Current Element is less than Top of stack break from loop
                    if (A.get(S.peek()) > A.get(i)) break;
                    // else remove the small element
                    S.pop();

                }
                // Push every element
                S.push(i);
            }
        return Result;
    }
}
