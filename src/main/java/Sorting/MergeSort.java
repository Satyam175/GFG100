package Sorting;

import java.util.Arrays;

public class MergeSort {

//    public static void main(String[] args) {
//        int[] arr1 = {1, 3, 7, 8};
//        int[] arr2 = {2, 4, 5, 6};
//        System.out.println(Arrays.toString(merge(arr1, arr2)));
//
//        int[] arr = {4, 2, 6, 5, 1, 3};
//        System.out.println(Arrays.toString(mergeSort(arr)));
//    }

//    divide the array to multiple single element arrays and merge them
//    time O(nl*ogn) & space O(N)
    private static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    //    Merge two sorted arrays
    private static int[] merge(int[] arr1, int[] arr2) {
        int[] combined = new int[arr1.length + arr2.length];
        int index = 0, i = 0, j = 0;

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

}
