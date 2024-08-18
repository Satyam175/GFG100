package Stacks;

import java.util.Stack;

public class DeleteMiddleElement {
    public static void main(String[] args) {

    }

    public static void deleteMid(Stack<Integer> stack) {
        int n = stack.size();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < n / 2; i++) {
            stack2.push(stack.pop());
        }
        stack.pop();
        while (!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }
    }

    public static void deleteMid2(Stack<Integer> stack, int n) {
        int poppedElements = n - stack.size();
        if (poppedElements == n/2){
            stack.pop();
            return;
        }
        int x = stack.pop();
        deleteMid2(stack, n);
        stack.push(x);
    }
}
