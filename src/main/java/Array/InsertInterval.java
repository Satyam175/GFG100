package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] arr = {{1, 4}, {2, 3}, {10, 15}, {20, 30}};
        int[][] arr2 = {{0, 40}};
        int[][] arr4 = {{1, 2}, {6,9}};
        int[][] arr3 = {{0, 137}, {141, 153}, {157, 207}, {236, 240}};
//        System.out.println(Arrays.deepToString(insertNewEvent(3, arr, new int[]{5, 6})));
        System.out.println(Arrays.deepToString(insertNewEvent(arr4, new int[]{3, 4})));
    }

    static int[][] insertNewEvent(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;

        // Add all intervals that come before the new interval
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals with the new interval
        while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // Add the merged interval to the result
        result.add(newInterval);

        // Add all intervals that come after the new interval
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
