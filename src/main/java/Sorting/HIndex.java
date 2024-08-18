package Sorting;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class HIndex {
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(hIndex(nums));
    }

    public static int hIndex(int[] citations) {
        int n = citations.length;
        quickSort(citations, 0, n-1);
        for(int i = 0;i<n; i++){
            if(citations[i] < i+1){
                return i;
            }
        }
        return n;
    }

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
            if (arr[i] > arr[pivotIndex]) {
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
