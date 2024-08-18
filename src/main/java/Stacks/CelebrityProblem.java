package Stacks;

import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 1, 0},
                {0, 0, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 0}
        };

        System.out.println(celebrity(matrix, 4));
    }

    static int celebrity(int M[][], int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
        while (stack.size() >= 2) {
            int first = stack.pop();
            int second = stack.pop();

            if (M[first][second] == 1) {
                stack.push(second);
            } else {
                stack.push(first);
            }
        }
        int last = stack.pop();
        for (int i = 0; i < n; i++) {
            if (M[i][last] !=1 && i!=last){
                return -1;
            }
            if (M[last][i] != 0){
                return -1;
            }
        }
        return last;
    }
}
