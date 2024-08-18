package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 1, 7, 3, 2, 5};
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        int[] arr3 = {4, 1, 6, 7, 3, 2, 5};
        quickSort(arr3, 0, arr3.length - 1);
        System.out.println(Arrays.toString(arr3));
//        System.out.println(pivot(arr, 0, 6));
//        System.out.println(Arrays.toString(arr));
//        quickSort(arr2, 0, arr2.length - 1);
//        System.out.println(Arrays.toString(arr2));
    }

    //    sort the array around the pivot
//    time O(n*log n) & space O(1)
    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    private static int pivot(int[] arr, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;
        for (int i = swapIndex + 1; i <= endIndex; i++) {
            if (arr[i] < arr[pivotIndex]) {
                swapIndex++;
                swap(arr, swapIndex, i);
            }
        }
        swap(arr, pivotIndex, swapIndex);
        return swapIndex;
    }

    private static void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}
