package Array;

import java.util.HashMap;

public class ZeroSumSubArray {
    public static void main(String[] args) {
        int[] arr = {0,0,5,5,0};
        int n = arr.length;
        System.out.println("Total count of subarrays with sum zero is: " + findSubarraySumZeroCount(arr, n));
    }

    static int findSubarraySumZeroCount(int[] arr, int n) {
        // Map to store the frequency of prefix sums
        HashMap<Integer, Integer> prefixSumFrequency = new HashMap<>();
        int prefixSum = 0;
        int count = 0;

        // Initialize the map with the prefix sum 0 having frequency 1 to handle the case
        // where the subarray with sum 0 starts from index 0
        prefixSumFrequency.put(0, 1);

        for (int i = 0; i < n; i++) {
            // Update prefix sum
            prefixSum += arr[i];

            // If the same sum has been seen before, it means there are multiple subarrays which sum to zero
            if (prefixSumFrequency.containsKey(prefixSum)) {
                count += prefixSumFrequency.get(prefixSum);
            }

            // Update the frequency of this sum in the map
            prefixSumFrequency.put(prefixSum, prefixSumFrequency.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

}
