package Stacks;
import java.util.Stack;

public class ValidSubstringParan {
    public static void main(String[] args) {
        System.out.println(findMaxLen(")()())"));
    }

    static int findMaxLen(String S) {
        // code here
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Initialize with a dummy index to handle edge cases

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                stack.push(i); // Push index of opening parenthesis
            } else { // S.charAt(i) == ')'
                stack.pop(); // Pop the index of matching opening parenthesis
                if (!stack.isEmpty()) {
                    // Calculate the length of the valid substring
                    max = Math.max(max, i - stack.peek());
                } else {
                    // No more valid substring found, update the last index
                    stack.push(i);
                }
            }
        }
        return max;
    }
}
