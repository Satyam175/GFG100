package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class FindDuplicates {
    public static void main(String[] args) {
        int[] arr = {4, 4, 6, 6};
        System.out.println(findDuplicates(arr));
    }

//    public static ArrayList<Integer> duplicates(int[] arr, int n) {
//        ArrayList<Integer> encountered = new ArrayList<>();
//        ArrayList<Integer> duplicates = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            if (duplicates.contains(arr[i])) {
//                continue;
//            }
//            if (encountered.contains(arr[i])) {
//                duplicates.add(arr[i]);
//                continue;
//            }
//            encountered.add(arr[i]);
//        }
//        if (duplicates.isEmpty()) {
//            duplicates.add(-1);
//        }
//        return duplicates;
//    }
    /*
    This version uses a HashSet for both encountered and duplicate elements.
    The add method of HashSet returns false if the element is already present, which simplifies the logic for finding duplicates.
     Also, the final result is converted back to an ArrayList before returning.
     */

    public static ArrayList<Integer> duplicates(int arr[], int n) {
        HashSet<Integer> encountered = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int currentElement = arr[i];

            if (!encountered.add(currentElement)) {
                duplicates.add(currentElement);
            }
        }

        if (duplicates.isEmpty()) {
            duplicates.add(-1);
        }

        // Convert the HashSet to an array and sort it
        Integer[] sortedDuplicatesArray = duplicates.toArray(new Integer[0]);
        Arrays.sort(sortedDuplicatesArray);

        // Convert the array back to an ArrayList
        return new ArrayList<>(Arrays.asList(sortedDuplicatesArray));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> dups = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i : map.keySet()) {
            if (map.get(nums[i]) > 1) {
                dups.add(nums[i]);
            }
        }
        return dups;
    }
}
