package Learning.com.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int[][] A = new int[][]{    {2, 0, 2, 2, 2, 0, 2, 1, 1, 0},
                                    {0, 1, 2, 0, 2, 0, 0, 1, 0, 1},
                                    {0, 1, 1, 1, 2, 0, 1, 1, 2, 1},
                                    {2, 0, 2, 0, 1, 1, 2, 1, 0, 1},
                                    {1, 0, 1, 1, 0, 1, 2, 0, 2, 2},
                                    {0, 2, 1, 1, 2, 2, 0, 2, 1, 2},
                                    {2, 1, 0, 2, 0, 0, 0, 0, 1, 1},
                                    {2, 2, 0, 2, 2, 1, 1, 1, 2, 2}};

        System.out.println(solve(A));

    }
    public static int solve(int[][] A) {
        int rows = A.length; int cols = A[0].length;
        Queue<int[]> q = new LinkedList<>();
        int FreshCount=0;

        for(int i=0;i<rows;i++){
            for(int j =0;j<cols;j++){
                if (A[i][j]==1){
                    FreshCount++;
                }else if (A[i][j]==2){
                    q.offer(new int[]{i,j});
                }
            }
        }

        int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int step =0;
        while(!q.isEmpty() && FreshCount!=0){
            int size = q.size();

            for(int i=0;i<size;i++){
                int[] Curr = q.poll();
                for(int[] dir: DIRS){
                    int NextX = Curr[0]+dir[0];
                    int NextY = Curr[1]+dir[1];
                    if (NextX >= 0 && NextX < rows && NextY >= 0 && NextY <cols && A[NextX][NextY]==1 ){
                        q.offer(new int[]{NextX, NextY});
                        A[NextX][NextY]=2;
                        FreshCount--;
                    }

                }
            }
            step++;
        }
        return (FreshCount==0)? step: -1;
    }
}
