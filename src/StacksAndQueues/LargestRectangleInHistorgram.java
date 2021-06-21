package Learning.com.StacksAndQueues;

import javafx.beans.binding.When;

import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangleInHistorgram {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(1);
        A.add(5);
        A.add(6);
        A.add(2);
        A.add(3);

        System.out.println(Solve(A));

    }

    public static int Solve(ArrayList<Integer> A){
        int N = A.size();
        Stack<Integer> stack = new Stack<>();
        int MaxArea =0;
        stack.push(-1);

        for(int i=0;i<N;i++){
            // Calculate Max Area
            while (stack.peek()!=-1 && A.get(stack.peek()) >= A.get(i)){
                int tempArea = A.get(stack.pop()) * (i-stack.peek()-1);
                MaxArea = Math.max(MaxArea, tempArea);
            }
            stack.push(i);
        }

        while (stack.peek()!=-1){
            MaxArea = Math.max(MaxArea, A.get(stack.pop()) * (A.size()-stack.peek()-1));
        }
        return MaxArea;

    }
}
