package Strings;

import java.util.Stack;

public class BalancedParentheses {
    public static void main(String[] args) {
        System.out.println(isBalanced2("((()))()(())"));
    }

//  time O(N) and space O(1)
    public static boolean isBalanced(String exp) {
        int count = 0;

        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i)=='('){
                count++;
            }
            else {
                count--;
            }
            if (count<0){
                return false;
            }
        }
        return count == 0;
    }

//    using stack time O(N) and space O(1)
    public static boolean isBalanced2(String exp){
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i<exp.length();i++){
            if (exp.charAt(i)=='('){
                stack.push('(');
            } else if (!stack.isEmpty() && stack.peek()=='('){
                stack.pop();
            }
            else return false;
        }
        return stack.isEmpty();
    }

}
