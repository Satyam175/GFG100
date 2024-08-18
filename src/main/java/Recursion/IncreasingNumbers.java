package Recursion;

import java.util.ArrayList;

public class IncreasingNumbers {
    public static void main(String[] args) {
        System.out.println(increasingNumbers(2));
    }

    public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (n <= 0) return ans;

        if (n == 1) {
            // For n = 1, we simply return the numbers from 0 to 9.
            for (int i = 0; i <= 9; i++) {
                ans.add(i);
            }
        } else {
            // For n > 1, generate numbers with strictly increasing digits
            generateNumbers(ans, "", 1, n);
        }

        return ans;
    }

    private static void generateNumbers(ArrayList<Integer> ans, String current, int start, int n) {
        if (current.length() == n) {
            ans.add(Integer.parseInt(current));
            return;
        }

        for (int i = start; i <= 9; i++) {
            generateNumbers(ans, current + i, i + 1, n);
        }
    }
}
