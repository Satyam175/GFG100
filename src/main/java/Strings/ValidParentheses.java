package Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("([])"));
    }

    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('[',']');
        map.put('{','}');
        map.put('(',')');
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()){
            if (map.keySet().contains(c)){
                stack.push(c);
            }
            else if (stack.isEmpty()){
                return false;
            } else if (c ==  map.get(stack.peek())) {
                stack.pop();
            } else return false;
        }
        return stack.isEmpty();
    }

    public static boolean isValid2(String s){
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '('){
                stack.push(')');
            } else if (c=='{') {
                stack.push('}');
            } else if (c=='['){
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

}
