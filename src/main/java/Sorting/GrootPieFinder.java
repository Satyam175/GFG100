package Sorting;

import java.util.*;

public class GrootPieFinder {

    public static List<List<Integer>> findPies(int[] sweetnessValues, int desiredSweetness) {
        List<List<Integer>> result = new ArrayList<>();
//        rec(sweetnessValues, desiredSweetness, sweetnessValues.length -1, result);
        return result;
    }

    public static void main(String[] args) {
        int[] pies1 = {1, 2, 3, 2, 1};
        int target1 = 6;
        List<List<Integer>> result1 = findPies(pies1, target1);
        System.out.println("Result 1: " + result1); // should print [[0, 1, 2], [2, 1, 0]]

        int[] pies2 = {8, 4, 3, 2, 6, 5};
        int target2 = 6;
        List<List<Integer>> result2 = findPies(pies2, target2);
        System.out.println("Result 2: " + result2); // should print [[1, 3], [4]]
    }
}
