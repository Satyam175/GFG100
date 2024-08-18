package Array;

import java.util.Arrays;

public class CheckPair {
    public static void main(String... args) {
        int[] arr = new int[]{1, 4, 45, 6, 10, 8};
        System.out.println(hasSum(arr, 6, 16));
    }

    //    two pointer technique time complexity O(NLogN), space complexity O(1)
    static boolean hasSum(int[] arr, int n, int x) {
//        Arrays.sort(arr);
//        insertionSort(arr);
//        arr = mergeSort(arr);
        quickSort(arr, 0, arr.length - 1);
        int beginingIndex = 0;
        int endingIndex = n - 1;

        while (beginingIndex < endingIndex) {
            if (arr[beginingIndex] + arr[endingIndex] == x) {
                return true;
            } else if (arr[beginingIndex] + arr[endingIndex] < x) {
                beginingIndex++;
            } else {
                endingIndex--;
            }
        }
        return false;
    }

    //    Insertion Sort
    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }

//    mergeSort

    private static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    //    merge two sorted arrays
    private static int[] merge(int[] arr1, int[] arr2) {
        int[] combined = new int[arr1.length + arr2.length];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                combined[index] = arr1[i];
                i++;
                index++;
            } else {
                combined[index] = arr2[j];
                j++;
                index++;
            }
        }

        while (i < arr1.length) {
            combined[index] = arr1[i];
            i++;
            index++;
        }
        while (j < arr2.length) {
            combined[index] = arr2[j];
            j++;
            index++;
        }
        return combined;
    }

    //    quick sort
    private static void quickSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int pivotIndex = pivot(arr, startIndex, endIndex);
            quickSort(arr, startIndex, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, endIndex);
        }
    }

    //    pivot
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

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

//    time complexity O(N^2), space complexity O(1)

//    static boolean hasSum(int[] arr, int n, int x){
//        for (int i = 0; i< n-1 ;i ++){
//            for (int j = 1;j<n;j++){
//                if (arr[i] + arr[j] == x){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
