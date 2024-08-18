package Stacks;

import java.util.Arrays;

public class NearestShortestTower {


    public static void main(String[] args) {
        int[] towerHeights = {3, 6, 7, 2, 5};
        int[] nearestTowers = nearestShorterTower(towerHeights);
        System.out.println(Arrays.toString(nearestTowers)); // Output: [3, 3, 3, -1, 3]
    }

    public static int[] nearestShorterTower(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        java.util.Stack<Integer> stack = new java.util.Stack<>();

        // Iterate through the array from left to right
        for (int i = 0; i < n; i++) {
            // While the stack is not empty and the current tower is taller than the tower at the top of the stack
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int top = stack.pop(); // Pop the top tower index from the stack
                // Update result for the tower at index 'top' with the current tower index 'i'
                result[top] = i;
            }
            // Push the current tower index 'i' onto the stack
            stack.push(i);
        }

        stack.clear(); // Clear the stack for the next iteration

        // Iterate through the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // While the stack is not empty and the current tower is taller than the tower at the top of the stack
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int top = stack.pop(); // Pop the top tower index from the stack
                // If the result for the tower at index 'i' is not yet updated or the tower at index 'top' is closer
                if (result[top] == -1 || (top - i) < (i - result[top])) {
                    result[top] = i;
                }
            }
            // Push the current tower index 'i' onto the stack
            stack.push(i);
        }

        return result;
    }

}