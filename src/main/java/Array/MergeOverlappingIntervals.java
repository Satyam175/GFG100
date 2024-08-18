package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
//        int[][] intervals1 = {{1, 3}, {2, 4}, {6, 8}, {9, 10}};
//        int[][] result1 = overlappedInterval(intervals1);
//        System.out.println(Arrays.deepToString(result1));

        int[][] intervals2 = {{6, 8}, {1, 9}, {2, 4}, {4, 7}};
        int[][] result2 = merge(intervals2);
        System.out.println(Arrays.deepToString(result2));
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // Sort intervals based on the start time
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (currentInterval[1] >= interval[0]) {
                // Overlapping intervals, merge them
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            } else {
                // Non-overlapping interval found, add the merged interval to the result
                mergedIntervals.add(currentInterval);
                currentInterval = interval;
            }
        }

        // Add the last merged interval
        mergedIntervals.add(currentInterval);

        // Convert the list to array
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

}