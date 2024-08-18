package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChocolateDistribution {
    public static void main(String[] args) {
        ArrayList arr = new ArrayList(List.of(3, 4, 1, 9, 56, 7, 9, 12));
        System.out.println(findMinDiff(arr, arr.size(), 5));
    }

    public static long findMinDiff(ArrayList<Integer> a, int n, int m) {
        if (m > n) {
            return -1;
        }
        if (m == 0 || n == 0) {
            return 0;
        }
        a = (ArrayList<Integer>) a.stream().sorted().collect(Collectors.toList());
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i + m - 1 < n; i++) {
            minDiff = Math.min(minDiff, a.get(i + m -1) - a.get(i));
        }
        return minDiff;
    }
}
