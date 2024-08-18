package Array;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {9, 12}, {2, 4}, {6, 8}};
        System.out.println(Arrays.deepToString(freeInterval(arr, 4)));
    }

    static int[][] freeInterval(int[][] arr, int n) {
        if (n <= 0) {
            return arr;
        }
        int[][] ans = new int[n][2];
        int index = 0;

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        for (int i = 1; i < n; i++) {
            int[] prev = arr[i-1];
            int[] curr = arr[i];

            if (prev[1]<curr[0]){
                ans[index] = new int[]{prev[1], curr[0]};
                index++;
            }
        }
        return ans;
    }

//    static int[][] freeInterval(int[][] arr, int n) {
//        if (n <= 0) {
//            return arr;
//        }
//
//        int[][] ans = new int[n][2];
//
//        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));
//
//        for (int i = 1; i < n; i++) {
//            int[] previous = arr[i - 1];
//            int[] current = arr[i];
//
//            if (previous[1] < current[0]) {
//                ans[i - 1] = new int[]{previous[1], current[0]};
//            }
//        }
//        return ans;
//    }
}
