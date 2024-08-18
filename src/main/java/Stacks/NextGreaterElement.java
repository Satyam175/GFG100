package Stacks;

import java.util.Arrays;
import java.util.Locale;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        long[] arr = {1, 11, 2, 4};
        System.out.println(Arrays.toString(nextLargerElement2(arr, 4)));
    }

    public static long[] nextLargerElement(long[] arr, int n) {
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            long nextGreater = -1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i] && arr[j] > nextGreater) {
                    nextGreater = arr[j];
                    break;
                }
            }
            ans[i] = nextGreater;
        }
        return ans;
    }

    public static long[] nextLargerElement2(long[] arr, int n) {
        long[] ans = new long[n];
        Stack<Long> stack = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i % n]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i % n] = -1;
            } else {
                ans[i % n] = stack.peek();
            }
            stack.push(arr[i % n]);
        }
        return ans;
    }

//    public static long[] nextLargerElement(long[] arr, int n) {
//        long[] ans = new long[n];
//        Stack<Long> stack = new Stack<>();
//        for (int i = n - 1; i >= 0; i--) {
//            while (!stack.isEmpty() && stack.peek()<=arr[i]){
//                stack.pop();
//            }
//            if (stack.isEmpty()){
//                ans[i] = -1;
//            } else {
//                ans[i] = stack.peek();
//            }
//            stack.push(arr[i]);
//        }
//        return ans;
//    }

}
